package com.gqfbtc.mvp.delegate;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fivefivelike.mybaselibrary.view.IconFontTextview;
import com.gqfbtc.R;

/**
 * Created by 郭青枫 on 2017/10/14.
 */

public class HomeDelegate extends BaseFragentPullDelegate {
    public ViewHolder viewHolder;

    @Override
    public void initView() {
        viewHolder = new ViewHolder(getRootView());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    public static class ViewHolder {
        public View rootView;
        public LinearLayout lin_top_left_btn;
        public RecyclerView pull_recycleview;
        public SwipeRefreshLayout swipeRefreshLayout;
        public RelativeLayout no_data;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.lin_top_left_btn = (LinearLayout) rootView.findViewById(R.id.lin_top_left_btn);
            this.pull_recycleview = (RecyclerView) rootView.findViewById(R.id.pull_recycleview);
            this.swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
            this.no_data = (RelativeLayout) rootView.findViewById(R.id.no_data);
        }

    }
}
