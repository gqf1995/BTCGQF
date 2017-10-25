package com.gqfbtc.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.widget.TextView;

import com.gqfbtc.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 郭青枫 on 2017/10/25.
 */

public class SelectGuarantorAdapter extends CommonAdapter<String> {


    private AppCompatImageView iv_pic;
    private CircleImageView ic_header;
    private TextView tv_name;

    int selectPositon = -1;

    public int getSelectPositon() {
        return selectPositon;
    }

    public void setSelectPositon(int selectPositon) {
        int oldPosition = this.selectPositon;
        if (oldPosition != -1) {
            this.notifyItemChanged(oldPosition);
        }
        this.selectPositon = selectPositon;
        if (selectPositon != -1) {
            this.notifyItemChanged(selectPositon);
        }
    }

    public SelectGuarantorAdapter(Context context, List<String> datas) {
        super(context, R.layout.adapter_select_guarantor, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, final int position) {
        iv_pic = holder.getView(R.id.iv_pic);
        ic_header = holder.getView(R.id.ic_header);
        tv_name = holder.getView(R.id.tv_name);
        iv_pic.setBackgroundResource(selectPositon == position ? R.drawable.ic_choose_on : R.drawable.ic_choose_off);


    }

}
