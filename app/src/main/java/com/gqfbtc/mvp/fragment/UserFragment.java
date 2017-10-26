package com.gqfbtc.mvp.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.fivefivelike.mybaselibrary.base.BasePullFragment;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.R;
import com.gqfbtc.adapter.SetListAdapter;
import com.gqfbtc.entity.SetMenuEntity;
import com.gqfbtc.mvp.databinder.UserBinder;
import com.gqfbtc.mvp.delegate.UserDelegate;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends BasePullFragment<UserDelegate, UserBinder> {

    List<SetMenuEntity> defDatas;
    SetListAdapter setListAdapter;

    HeaderAndFooterWrapper adapter;

    String[] mTitle = {"我的广告", "收款地址", "收币地址",
            "设置", "常见问题", "关于我们", "客服中心",
            "推荐给朋友",
            "退出登陆"};
    int[] mImgId = {R.string.ic_guanggaofuwudan, R.string.ic_qianbao2, R.string.ic_fukuanfangshi, R.string.ic_shezhi,
            R.string.ic_changjianwenti, R.string.ic_guanyu, R.string.ic_kefu, R.string.ic_fenxiang,
            R.string.ic_tuichu};

    @Override
    protected Class<UserDelegate> getDelegateClass() {
        return UserDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("个人中心").setShowBack(false).setSubTitle("帮助"));
        initList();
    }

    private void initList() {
        viewDelegate.setShowNoData(false);
        defDatas = new ArrayList<>();
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[0]).setTitle(mTitle[0]).setHaveRightImg(true).setHaveLine(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[1]).setTitle(mTitle[1]).setHaveRightImg(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[2]).setTitle(mTitle[2]).setHaveRightImg(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[3]).setTitle(mTitle[3]).setHaveRightImg(true).setHaveLine(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[4]).setTitle(mTitle[4]).setHaveRightImg(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[5]).setTitle(mTitle[5]).setHaveRightImg(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[6]).setTitle(mTitle[6]).setHaveRightImg(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[7]).setTitle(mTitle[7]).setHaveRightImg(true).setHaveLine(true));
        defDatas.add(new SetMenuEntity().setLeftImgId(mImgId[8]).setTitle(mTitle[8]).setHaveRightImg(true).setHaveLine(true));
        setListAdapter = new SetListAdapter(getActivity(), defDatas);
        adapter = new HeaderAndFooterWrapper(setListAdapter);
        adapter.addHeaderView(initHeader());
        initRecycleViewPull(adapter, new LinearLayoutManager(getActivity()));
        viewDelegate.setIsLoadMore(false);
    }

    private View initHeader() {
        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_user_header, null);
        return view;
    }

    @Override
    public UserBinder getDataBinder(UserDelegate viewDelegate) {
        return new UserBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }

    @Override
    protected void refreshData() {
        viewDelegate.viewHolder.swipeRefreshLayout.setRefreshing(false);
    }
}
