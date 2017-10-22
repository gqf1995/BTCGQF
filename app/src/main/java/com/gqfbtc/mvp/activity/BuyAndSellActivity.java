package com.gqfbtc.mvp.activity;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.fivefivelike.mybaselibrary.base.BasePullActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.R;
import com.gqfbtc.adapter.AdvertisingAdapter;
import com.gqfbtc.mvp.databinder.BaseActivityPullBinder;
import com.gqfbtc.mvp.delegate.BaseActivityPullDelegate;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;


public class BuyAndSellActivity extends BasePullActivity<BaseActivityPullDelegate, BaseActivityPullBinder> {
    List<String> defDatas;
    HeaderAndFooterWrapper adapter;
    AdvertisingAdapter advertisingAdapter;

    @Override
    protected Class<BaseActivityPullDelegate> getDelegateClass() {
        return BaseActivityPullDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("买BTC").setSubTitle("帮助"));
        initList();
    }

    public View initTopView() {
        View view = getLayoutInflater().inflate(R.layout.layout_buy_and_sell, null);
        return view;
    }

    private void initList() {
        viewDelegate.setShowNoData(false);
        defDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            defDatas.add("");
        }
        advertisingAdapter = new AdvertisingAdapter(this, defDatas);
        adapter = new HeaderAndFooterWrapper(advertisingAdapter);
        adapter.addHeaderView(initTopView());
        initRecycleViewPull(adapter, new LinearLayoutManager(this));
    }


    @Override
    public BaseActivityPullBinder getDataBinder(BaseActivityPullDelegate viewDelegate) {
        return new BaseActivityPullBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

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
