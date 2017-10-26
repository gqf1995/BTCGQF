package com.gqfbtc.mvp.activity;

import android.view.View;

import com.blankj.utilcode.util.ScreenUtils;
import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gqfbtc.R;
import com.gqfbtc.entity.TabEntity;
import com.gqfbtc.mvp.delegate.MainDelegate;
import com.gqfbtc.mvp.fragment.AssetsFragment;
import com.gqfbtc.mvp.fragment.HomeFragment;
import com.gqfbtc.mvp.fragment.OrderFragment;
import com.gqfbtc.mvp.fragment.UserFragment;
import com.gqfbtc.widget.BoomButtom;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainDelegate> {

    private String[] mTitles = {"交易", "订单", "", "资产", "我的"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconSelectIds = {
            R.string.ic_jiaoyi, R.string.ic_dingdan, 0,
            R.string.ic_qianbao, R.string.ic_wode};

    private int[] mIconBoomIds = {
            R.string.ic_btc, R.string.ic_btc,
            R.string.ic_eth, R.string.ic_eth};

    private int[] mIconBoomColorIds = {
            R.color.white, R.color.color_f5a623,
            R.color.white, R.color.color_555555};

    private int[] mIconBoomBgColorIds = {
            R.color.color_f5a623, R.color.white,
            R.color.color_555555, R.color.white};

    private String[] mBoomTitles = {"挂单买", "挂单卖", "挂单买", "挂单卖"};
    private String[] mBoomSubtitles = {"BTC", "BTC", "ETH", "ETH"};

    List<BoomButtom.BoomBtnEntity> entities;
    List<View> views;

    @Override
    protected Class<MainDelegate> getDelegateClass() {
        return MainDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initBottomBtn();
        initFragment();
    }

    public void initFragment() {
        viewDelegate.initAddFragment(R.id.fl_root, getSupportFragmentManager());
        viewDelegate.addFragment(new HomeFragment());
        viewDelegate.addFragment(new OrderFragment());
        viewDelegate.addFragment(new AssetsFragment());
        viewDelegate.addFragment(new UserFragment());
        viewDelegate.showFragment(0);
        loginCls = LoginActivity.class;
        doubleClickActList.add(this.getClass().getName());
    }

    public void initBottomBtn() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], 0));
        }
        viewDelegate.viewHolder.tl_2.setIconVisible(false);
        viewDelegate.viewHolder.tl_2.setTabData(mTabEntities);
        viewDelegate.viewHolder.tl_2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position > 1) {
                    position = position - 1;
                }
                viewDelegate.showFragment(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewDelegate.viewHolder.tl_2.getmTabsContainer().getChildAt(2).setEnabled(false);

        entities = new ArrayList<>();
        views = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            entities.add(new BoomButtom.BoomBtnEntity().setmIcon(mIconBoomIds[i])
                    .setmTitle(mBoomTitles[i]).setmSubTitle(mBoomSubtitles[i])
                    .setBgColor(mIconBoomBgColorIds[i])
                    .setTxtColor(mIconBoomColorIds[i])
                    .setPadding(getResources().getDimensionPixelOffset(R.dimen.trans_15px))
                    .setxPositions(((ScreenUtils.getScreenWidth() - getResources().getDimensionPixelOffset(R.dimen.trans_50px)) / 4 * (i)) + getResources().getDimensionPixelOffset(R.dimen.trans_25px)
                            , getResources().getDimensionPixelOffset(R.dimen.trans_160px))
                    .setWidth((ScreenUtils.getScreenWidth() - getResources().getDimensionPixelOffset(R.dimen.trans_40px)) / 4));
        }
        viewDelegate.viewHolder.boom.setEntities(entities);
        viewDelegate.viewHolder.boom.setCenter((ScreenUtils.getScreenWidth() / 2) - getResources().getDimensionPixelOffset(R.dimen.trans_60px), getResources().getDimensionPixelOffset(R.dimen.trans_10px));
        viewDelegate.viewHolder.boom.setBoomBtn(views);
        viewDelegate.viewHolder.boom.setControlView(viewDelegate.viewHolder.tv_center_btn);
        viewDelegate.viewHolder.boom.setClickable(false);

    }


}
