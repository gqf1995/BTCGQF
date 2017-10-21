package com.gqfbtc.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.gqfbtc.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 郭青枫 on 2017/10/17.
 */

public class AdvertisingAdapter extends CommonAdapter<String> {


    private CircleImageView ic_pic;
    private TextView tv_name;
    private TextView tv_appraise;
    private TextView tv_label1;
    private TextView tv_label2;
    private TextView tv_sell_type;
    private TextView tv_sell_money;
    private TextView tv_sell_coin;
    private TextView tv_start_type;
    private TextView tv_start_money;
    private TextView tv_start_coin;
    private TextView tv_money;
    private TextView tv_coin;
    private TextView tv_buy;

    public AdvertisingAdapter(Context context, List<String> datas) {
        super(context, R.layout.adapter_advertising, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, final int position) {
        ic_pic = holder.getView(R.id.ic_pic);
        tv_name = holder.getView(R.id.tv_name);
        tv_appraise = holder.getView(R.id.tv_appraise);
        tv_label1 = holder.getView(R.id.tv_label1);
        tv_label2 = holder.getView(R.id.tv_label2);
        tv_sell_type = holder.getView(R.id.tv_sell_type);
        tv_sell_money = holder.getView(R.id.tv_sell_money);
        tv_sell_coin = holder.getView(R.id.tv_sell_coin);
        tv_start_type = holder.getView(R.id.tv_start_type);
        tv_start_money = holder.getView(R.id.tv_start_money);
        tv_start_coin = holder.getView(R.id.tv_start_coin);
        tv_money = holder.getView(R.id.tv_money);
        tv_coin = holder.getView(R.id.tv_coin);
        tv_buy = holder.getView(R.id.tv_buy);
    }

}
