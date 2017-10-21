package com.gqfbtc.mvp.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;

import com.fivefivelike.mybaselibrary.base.BasePullFragment;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.adapter.AdvertisingAdapter;
import com.gqfbtc.adapter.OrderListAdapter;
import com.gqfbtc.mvp.databinder.OrderBinder;
import com.gqfbtc.mvp.delegate.OrderDelegate;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郭青枫 on 2017/10/16.
 */

public class OrderFragment extends BasePullFragment<OrderDelegate, OrderBinder> {

    List<String> defDatas;
    OrderListAdapter adapter;

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("订单消息").setSubTitle("客服"));
        initList();
    }

    private void initList() {
        defDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            defDatas.add("");
        }
        adapter = new OrderListAdapter(getActivity(), defDatas);
        initRecycleViewPull(adapter, new LinearLayoutManager(getActivity()));
    }

    @Override
    public OrderBinder getDataBinder(OrderDelegate viewDelegate) {
        return new OrderBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }

    @Override
    protected Class<OrderDelegate> getDelegateClass() {
        return OrderDelegate.class;
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
