package com.gqfbtc.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;

import com.fivefivelike.mybaselibrary.base.BaseDataBindFragment;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gqfbtc.R;
import com.gqfbtc.entity.TabEntity;
import com.gqfbtc.mvp.databinder.AssetsBtcBinder;
import com.gqfbtc.mvp.delegate.AssetsBtcDelegate;

import java.util.ArrayList;

/**
 * Created by 郭青枫 on 2017/10/21.
 */

public class AssetsBtcFragment extends BaseDataBindFragment<AssetsBtcDelegate, AssetsBtcBinder> {
    private String[] mTitles = {"充值", "提现"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        tablayout();
    }

    private void tablayout() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], 0, 0));
        }
        viewDelegate.viewHolder.tl_2.setIconVisible(false);
        viewDelegate.viewHolder.tl_2.setTabData(mTabEntities);
        viewDelegate.viewHolder.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewDelegate.viewHolder.swipeRefreshLayout.setRefreshing(false);
            }
        });
        viewDelegate.viewHolder.tl_2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewDelegate.showFragment(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        initFragment();
    }

    public void initFragment() {
        viewDelegate.initAddFragment(R.id.fl_root, getChildFragmentManager());
        viewDelegate.addFragment(new AssetsBtcTopupFragment());
        viewDelegate.addFragment(new AssetsBtcWithdrawalFragment());
        viewDelegate.showFragment(0);
    }

    @Override
    public AssetsBtcBinder getDataBinder(AssetsBtcDelegate viewDelegate) {
        return new AssetsBtcBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }


    @Override
    protected Class<AssetsBtcDelegate> getDelegateClass() {
        return AssetsBtcDelegate.class;
    }


}
