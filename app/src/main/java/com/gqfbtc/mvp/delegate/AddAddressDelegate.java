package com.gqfbtc.mvp.delegate;


import android.view.View;

import com.fivefivelike.mybaselibrary.base.BaseDelegate;
import com.gqfbtc.R;

public class AddAddressDelegate extends BaseDelegate {
    public ViewHolder viewHolder;

    @Override
    public void initView() {
        viewHolder = new ViewHolder(getRootView());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_address;
    }


    public static class ViewHolder {
        public View rootView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;

        }

    }
}
