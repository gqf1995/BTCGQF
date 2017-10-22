package com.gqfbtc.mvp.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ScreenUtils;
import com.fivefivelike.mybaselibrary.base.BasePullFragment;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.gqfbtc.R;
import com.gqfbtc.adapter.AdvertisingAdapter;
import com.gqfbtc.entity.TabEntity;
import com.gqfbtc.mvp.databinder.HomeBinder;
import com.gqfbtc.mvp.delegate.HomeDelegate;
import com.gqfbtc.mvp.popu.HomeLeftPopu;
import com.gqfbtc.mvp.popu.HomeRightPopu;
import com.gqfbtc.widget.CommonTabLayout;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

/**
 * Created by 郭青枫 on 2017/10/16.
 */

public class HomeFragment extends BasePullFragment<HomeDelegate, HomeBinder> {

    List<String> defDatas;
    HeaderAndFooterWrapper adapter;
    AdvertisingAdapter advertisingAdapter;

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("交易").setShowBack(false).setSubTitle(getResources().getString(R.string.ic_jia)));
        initList();
        viewDelegate.viewHolder.lin_top_left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTopLeftPopu(v);
            }
        });
    }

    String[] selectLeft = {"买BTC", "卖BTC", "买ETH", "卖ETH"};
    String[] selectRight = {"挂单买BTC", "挂单卖BTC", "挂单买ETH", "挂单卖ETH"};
    int[] selectRightIds = {R.string.ic_btc, R.string.ic_btc, R.string.ic_eth, R.string.ic_eth};

    private void initTopLeftPopu(View view) {
        HomeLeftPopu homeLeftPopu = new HomeLeftPopu(getActivity());
        homeLeftPopu.setSelectItem(selectLeft);
        homeLeftPopu.showAsDropDown(view);


    }


    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntitie2s = new ArrayList<>();

    public View initTopView() {
        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_home_top_view, null);
        BGABanner bgaBanner = (BGABanner) view.findViewById(R.id.banner_guide_content);


        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.banner));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.banner));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.banner));
        bgaBanner.setData(views);
        //宽640 高240
        ViewGroup.LayoutParams layoutParams = bgaBanner.getLayoutParams();
        layoutParams.height = ScreenUtils.getScreenWidth() * 240 / 640;
        bgaBanner.setLayoutParams(layoutParams);
        String[] mTitles = {"BTC", "ETH"};
        String[] mTitle2s = {"买币", "卖币"};

        CommonTabLayout tl_8 = (CommonTabLayout) view.findViewById(R.id.tl_8);
        CommonTabLayout tl_9 = (CommonTabLayout) view.findViewById(R.id.tl_9);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], 0, 0));
            mTabEntitie2s.add(new TabEntity(mTitle2s[i], 0, 0));
        }
        tl_8.setmIndicatorId(R.drawable.shap_gray_border_max_radiu);
        tl_9.setmIndicatorId(R.drawable.shap_gray_border_max_radiu);
        tl_8.setTabData(mTabEntities);
        tl_9.setTabData(mTabEntitie2s);

        return view;

    }

    private void initList() {
        defDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            defDatas.add("");
        }
        advertisingAdapter = new AdvertisingAdapter(getActivity(), defDatas);
        adapter = new HeaderAndFooterWrapper(advertisingAdapter);
        adapter.addHeaderView(initTopView());
        initRecycleViewPull(adapter, new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void clickRightTv() {
        super.clickRightTv();

        HomeRightPopu homeRightPopu = new HomeRightPopu(getActivity());
        homeRightPopu.setSelectItem(selectRight, selectRightIds);
        homeRightPopu.showAsDropDown(viewDelegate.getmToolbarSubTitle());

    }

    @Override
    public HomeBinder getDataBinder(HomeDelegate viewDelegate) {
        return new HomeBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }

    @Override
    protected Class<HomeDelegate> getDelegateClass() {
        return HomeDelegate.class;
    }

    @Override
    protected void refreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    list.add("");
                }
                getDataBack(defDatas, list, adapter);
            }
        }, 2000);
    }
}
