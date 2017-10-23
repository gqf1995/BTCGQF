package com.gqfbtc.mvp.activity;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.fivefivelike.mybaselibrary.base.BasePullActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.R;
import com.gqfbtc.adapter.MyAddressAdapter;
import com.gqfbtc.mvp.databinder.BaseActivityPullBinder;
import com.gqfbtc.mvp.delegate.BaseActivityPullDelegate;

import java.util.ArrayList;
import java.util.List;


public class MyAddressActivity extends BasePullActivity<BaseActivityPullDelegate, BaseActivityPullBinder> {


    List<String> defDatas;
    MyAddressAdapter adapter;

    @Override
    protected Class<BaseActivityPullDelegate> getDelegateClass() {
        return BaseActivityPullDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("收货地址管理").setSubTitle("帮助"));
        addFootView();
        initList();
    }

    private void addFootView() {
        View view = getLayoutInflater().inflate(R.layout.layout_bottom_commit, null);
        TextView tv_commit = (TextView) view.findViewById(R.id.tv_commit);

        viewDelegate.viewHolder.lin_pull.addView(view);

    }

    private void initList() {
        viewDelegate.setShowNoData(false);
        defDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            defDatas.add("");
        }
        adapter = new MyAddressAdapter(this, defDatas);
        initRecycleViewPull(adapter, new LinearLayoutManager(this));
        viewDelegate.setIsLoadMore(false);
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
