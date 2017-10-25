package com.gqfbtc.mvp.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;

import com.fivefivelike.mybaselibrary.base.BasePullFragment;
import com.gqfbtc.adapter.MyAddressAdapter;
import com.gqfbtc.mvp.databinder.BaseFragmentPullBinder;
import com.gqfbtc.mvp.delegate.BaseFragentPullDelegate;

import java.util.ArrayList;
import java.util.List;


public class EthAndBtcAddressFragment extends BasePullFragment<BaseFragentPullDelegate, BaseFragmentPullBinder> {


    List<String> defDatas;
    MyAddressAdapter adapter;

    @Override
    protected Class<BaseFragentPullDelegate> getDelegateClass() {
        return BaseFragentPullDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initList();
    }


    private void initList() {
        viewDelegate.setShowNoData(false);
        defDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            defDatas.add("");
        }
        adapter = new MyAddressAdapter(getActivity(), defDatas);
        initRecycleViewPull(adapter, new LinearLayoutManager(getActivity()));
        viewDelegate.setIsLoadMore(false);
    }

    @Override
    public BaseFragmentPullBinder getDataBinder(BaseFragentPullDelegate viewDelegate) {
        return new BaseFragmentPullBinder(viewDelegate);
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
