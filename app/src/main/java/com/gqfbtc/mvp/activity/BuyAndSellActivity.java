package com.gqfbtc.mvp.activity;

import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fivefivelike.mybaselibrary.base.BasePullActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.R;
import com.gqfbtc.adapter.MessageAdapter;
import com.gqfbtc.adapter.SelectGuarantorAdapter;
import com.gqfbtc.mvp.databinder.BaseActivityPullBinder;
import com.gqfbtc.mvp.delegate.BaseActivityPullDelegate;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;


public class BuyAndSellActivity extends BasePullActivity<BaseActivityPullDelegate, BaseActivityPullBinder> {
    List<String> defDatas;
    HeaderAndFooterWrapper adapter;
    MessageAdapter messageAdapter;

    @Override
    protected Class<BaseActivityPullDelegate> getDelegateClass() {
        return BaseActivityPullDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("买BTC").setSubTitle("帮助"));
        initList();
        initBottomView();
    }

    RecyclerView rv_guarantor;
    SelectGuarantorAdapter selectGuarantorAdapter;

    public View initTopView() {
        View view = getLayoutInflater().inflate(R.layout.layout_buy_and_sell, null);
        rv_guarantor = (RecyclerView) view.findViewById(R.id.rv_guarantor);

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringList.add("");
        }
        selectGuarantorAdapter = new SelectGuarantorAdapter(this, stringList);
        rv_guarantor.setLayoutManager(new GridLayoutManager(this, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rv_guarantor.setAdapter(selectGuarantorAdapter);
        selectGuarantorAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                selectGuarantorAdapter.setSelectPositon(selectGuarantorAdapter.getSelectPositon() == position ? -1 : position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        return view;
    }

    private void initBottomView() {
        View view = getLayoutInflater().inflate(R.layout.layout_buy_bottom, null);
        view.findViewById(R.id.tv_commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivity(WaitTransactActivity.class).startAct();
            }
        });

        viewDelegate.viewHolder.lin_pull.addView(view);
    }

    private void initList() {
        viewDelegate.setShowNoData(false);
        defDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            defDatas.add("");
        }
        messageAdapter = new MessageAdapter(this, defDatas);
        adapter = new HeaderAndFooterWrapper(messageAdapter);
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
