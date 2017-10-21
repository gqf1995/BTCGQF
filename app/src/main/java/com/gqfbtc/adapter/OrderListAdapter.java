package com.gqfbtc.adapter;

import android.content.Context;
import android.widget.TextView;

import com.gqfbtc.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by 郭青枫 on 2017/10/19.
 */

public class OrderListAdapter extends CommonAdapter<String> {


    private TextView tv_title;
    private TextView tv_type;
    private TextView tv_time;
    private TextView tv_status;
    private TextView tv_price;
    private TextView tv_order_money;

    public OrderListAdapter(Context context, List<String> datas) {
        super(context, R.layout.adapter_order_list, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, final int position) {
        tv_title = holder.getView(R.id.tv_title);
        tv_type = holder.getView(R.id.tv_type);
        tv_time = holder.getView(R.id.tv_time);
        tv_status = holder.getView(R.id.tv_status);
        tv_price = holder.getView(R.id.tv_price);
        tv_order_money = holder.getView(R.id.tv_order_money);
    }

}
