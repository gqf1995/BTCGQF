package com.gqfbtc.adapter;

import android.content.Context;
import android.widget.TextView;

import com.gqfbtc.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 郭青枫 on 2017/10/23.
 */

public class MessageAdapter extends CommonAdapter<String> {

    private TextView tv_title;
    private CircleImageView ic_pic;
    private TextView tv_name;
    private TextView tv_time;
    private TextView tv_content;

    public MessageAdapter(Context context, List<String> datas) {
        super(context, R.layout.adapter_message, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, final int position) {
        tv_title = holder.getView(R.id.tv_title);
        ic_pic = holder.getView(R.id.ic_pic);
        tv_name = holder.getView(R.id.tv_name);
        tv_content = holder.getView(R.id.tv_content);

    }

}
