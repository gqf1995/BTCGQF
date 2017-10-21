package com.gqfbtc.mvp.fragment;

import android.view.View;

import com.fivefivelike.mybaselibrary.base.BaseFragment;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.gqfbtc.entity.TabEntity;
import com.gqfbtc.mvp.delegate.AssetsDelegate;

import java.util.ArrayList;

/**
 * Created by 郭青枫 on 2017/10/16.
 */

public class AssetsFragment extends BaseFragment<AssetsDelegate> {

    private String[] mTitles = {"BTC", "ETH"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("").setShowBack(false).setSubTitle("客服"));
        viewDelegate.getmToolbarTitle().setVisibility(View.GONE);
        initTitle();
    }

    private void initTitle() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], 0, 0));
        }
        viewDelegate.viewHolder.tl_2.setIconVisible(false);
        viewDelegate.viewHolder.tl_2.setTabData(mTabEntities);

    }

    @Override
    protected Class<AssetsDelegate> getDelegateClass() {
        return AssetsDelegate.class;
    }
}
