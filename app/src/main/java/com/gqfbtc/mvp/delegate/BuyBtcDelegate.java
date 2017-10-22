package com.gqfbtc.mvp.delegate;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fivefivelike.mybaselibrary.base.BaseDelegate;
import com.fivefivelike.mybaselibrary.view.IconFontTextview;
import com.gqfbtc.R;
import com.gqfbtc.widget.SingleLineZoomTextView;

public class BuyBtcDelegate extends BaseDelegate {
    public ViewHolder viewHolder;

    @Override
    public void initView() {
        viewHolder = new ViewHolder(getRootView());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_btc;
    }


    public static class ViewHolder {
        public View rootView;
        public SingleLineZoomTextView tv_total_price;
        public SingleLineZoomTextView tv_unit_price;
        public TextView tv_toast;
        public TextView tv_handling_charge;
        public TextView tv_putong_toast;
        public TextView tv_putong_more;
        public TextView tv_putong_commit;
        public TextView tv_anquan_toast;
        public TextView tv_anquan_more;
        public TextView tv_anquan_commit;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_total_price = (SingleLineZoomTextView) rootView.findViewById(R.id.tv_total_price);
            this.tv_unit_price = (SingleLineZoomTextView) rootView.findViewById(R.id.tv_unit_price);
            this.tv_toast = (TextView) rootView.findViewById(R.id.tv_toast);
            this.tv_handling_charge = (TextView) rootView.findViewById(R.id.tv_handling_charge);
            this.tv_putong_toast = (TextView) rootView.findViewById(R.id.tv_putong_toast);
            this.tv_putong_more = (TextView) rootView.findViewById(R.id.tv_putong_more);
            this.tv_putong_commit = (TextView) rootView.findViewById(R.id.tv_putong_commit);
            this.tv_anquan_toast = (TextView) rootView.findViewById(R.id.tv_anquan_toast);
            this.tv_anquan_more = (TextView) rootView.findViewById(R.id.tv_anquan_more);
            this.tv_anquan_commit = (TextView) rootView.findViewById(R.id.tv_anquan_commit);
        }

    }
}
