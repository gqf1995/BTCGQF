package com.gqfbtc.mvp.delegate;

import android.view.View;
import android.widget.LinearLayout;

import com.fivefivelike.mybaselibrary.base.BaseDelegate;
import com.gqfbtc.R;
import com.gqfbtc.widget.CommonTabLayout;

/**
 * Created by 郭青枫 on 2017/10/14.
 */

public class AssetsDelegate extends BaseDelegate {
    public ViewHolder viewHolder;

    @Override
    public void initView() {
        viewHolder = new ViewHolder(getRootView());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_assets;
    }


    public static class ViewHolder {
        public View rootView;
        public CommonTabLayout tl_2;
        public LinearLayout lin_top_left_btn;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tl_2 = (CommonTabLayout) rootView.findViewById(R.id.tl_2);
            this.lin_top_left_btn = (LinearLayout) rootView.findViewById(R.id.lin_top_left_btn);
        }

    }
}
