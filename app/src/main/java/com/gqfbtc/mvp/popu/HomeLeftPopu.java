package com.gqfbtc.mvp.popu;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fivefivelike.mybaselibrary.view.popupWindow.BasePopupWindow;
import com.gqfbtc.R;
import com.gqfbtc.adapter.HomeLSelectAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liugongce on 2017/8/17.
 */

public class HomeLeftPopu extends BasePopupWindow {


    private RecyclerView recycler_view;
    private List<String> list;
    private HomeLSelectAdapter adapter;

    public HomeLeftPopu(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_home_top_left_popu;
    }

    @Override
    public void initView() {
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        recycler_view = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new HomeLSelectAdapter(context, list);
        recycler_view.setLayoutManager(new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recycler_view.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

                adapter.setSelectPositon(adapter.getSelectPositon() == position ? -1 : position);

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }


    public HomeLeftPopu setSelectItem(String[] items) {
        list.clear();
        List<String> itemList = Arrays.asList(items);
        if (itemList != null && itemList.size() > 0) {
            list.addAll(itemList);
        }
        adapter.notifyDataSetChanged();
        return this;
    }


}
