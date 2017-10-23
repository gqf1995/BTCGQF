package com.gqfbtc.mvp.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.fivefivelike.mybaselibrary.base.BasePullFragment;
import com.gqfbtc.R;
import com.gqfbtc.adapter.RecordAdapter;
import com.gqfbtc.mvp.activity.MyAddressActivity;
import com.gqfbtc.mvp.databinder.BaseFragmentPullBinder;
import com.gqfbtc.mvp.delegate.BaseFragentPullDelegate;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郭青枫 on 2017/10/21.
 */

public class AssetsBtcWithdrawalFragment extends BasePullFragment<BaseFragentPullDelegate, BaseFragmentPullBinder> {

    List<String> defDatas;
    RecordAdapter recordAdapter;
    HeaderAndFooterWrapper adapter;

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initList();


    }

    private void initList() {
        defDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            defDatas.add("");
        }
        recordAdapter = new RecordAdapter(getActivity(), defDatas);
        adapter = new HeaderAndFooterWrapper(recordAdapter);
        adapter.addHeaderView(initHeaderView());
        initRecycleViewPull(adapter, new LinearLayoutManager(getActivity()));
        viewDelegate.setIsPullDown(false);
    }

    private View initHeaderView() {
        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_withdrawal, null);
        view.findViewById(R.id.tv_address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyAddressActivity.class));
            }
        });

        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return view;
    }

    @Override
    public BaseFragmentPullBinder getDataBinder(BaseFragentPullDelegate viewDelegate) {
        return new BaseFragmentPullBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }


    @Override
    protected Class<BaseFragentPullDelegate> getDelegateClass() {
        return BaseFragentPullDelegate.class;
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
