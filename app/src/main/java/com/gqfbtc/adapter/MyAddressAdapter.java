package com.gqfbtc.adapter;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gqfbtc.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by 郭青枫 on 2017/10/23.
 */

public class MyAddressAdapter extends CommonAdapter<String> {


    private TextView tv_name;
    private TextView tv_bank;
    private TextView tv_address;
    private LinearLayout lin_delect;

    public MyAddressAdapter(Context context, List<String> datas) {
        super(context, R.layout.adapter_my_address, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, final int position) {
        tv_name = holder.getView(R.id.tv_name);
        tv_bank = holder.getView(R.id.tv_bank);
        tv_address = holder.getView(R.id.tv_address);
        lin_delect = holder.getView(R.id.lin_delect);
    }

}
