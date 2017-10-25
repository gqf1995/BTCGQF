package com.gqfbtc.mvp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.fivefivelike.mybaselibrary.base.BaseDataBindActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gqfbtc.adapter.SlidWithFragmentPagerAdapter;
import com.gqfbtc.entity.TabEntity;
import com.gqfbtc.mvp.databinder.MyAddressBinder;
import com.gqfbtc.mvp.delegate.MyAddressDelegate;
import com.gqfbtc.mvp.fragment.EthAndBtcAddressFragment;

import java.util.ArrayList;


public class MyAddressActivity extends BaseDataBindActivity<MyAddressDelegate, MyAddressBinder> {

    private String[] mTitles = {"BTC", "ETH"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected Class<MyAddressDelegate> getDelegateClass() {
        return MyAddressDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("").setSubTitle("帮助"));
        viewDelegate.getmToolbarTitle().setVisibility(View.GONE);
        initTitle();
        viewDelegate.viewHolder.tv_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewDelegate.viewHolder.tl_2.getCurrentTab() == 0) {
                    gotoActivity(AddAddressActivity.class)
                            .startAct();
                } else {
                    gotoActivity(AddCollectionAddressActivity.class)
                            .startAct();
                }
            }
        });
    }

    private void initTitle() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], 0, 0));
        }
        viewDelegate.viewHolder.tl_2.setIconVisible(false);
        viewDelegate.viewHolder.tl_2.setTabData(mTabEntities);
        initFragment();
        viewDelegate.viewHolder.tl_2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewDelegate.viewHolder.vp_address.setCurrentItem(position, true);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void initFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            fragments.add(new EthAndBtcAddressFragment());
        }
        SlidWithFragmentPagerAdapter slidWithFragmentPagerAdapter = new SlidWithFragmentPagerAdapter(getSupportFragmentManager(), mTitles, fragments);
        viewDelegate.viewHolder.vp_address.setAdapter(slidWithFragmentPagerAdapter);
        viewDelegate.viewHolder.vp_address.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewDelegate.viewHolder.tl_2.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public MyAddressBinder getDataBinder(MyAddressDelegate viewDelegate) {
        return new MyAddressBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }

}
