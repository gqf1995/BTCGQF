package com.gqfbtc.mvp.activity;

import android.content.Intent;
import android.view.View;

import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.fivefivelike.mybaselibrary.base.BaseDataBindActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.R;
import com.gqfbtc.base.StaticFinal;
import com.gqfbtc.mvp.databinder.LoginAndRegisterBinder;
import com.gqfbtc.mvp.delegate.LoginAndRegisterDelegate;
import com.gqfbtc.mvp.delegate.SuccessDelegate;

public class SuccessActivity extends BaseActivity<SuccessDelegate> {


    String[] toolTitle = {"找回密码", "发布成功", "评价成功", "修改成功"};
    String[] title = {"密码设置成功", "广告发布成功", "评价提交成功", "修改成功，请重新登陆"};
    String[] content = {
            "已为您重新登陆，正在为您跳转到首页"
            , "正在为您跳转到广告详情页"
            , "感谢您的评价，正在为您跳转到订单详情页"
            , "您已成功修改登录密码，正在为您跳转\n至登录页重新登陆"
    };
    String[] toast = {"立即前往", "立即前往", "立即前往", "立即前往"};
    Class[] classes = {MainActivity.class, MainActivity.class, MainActivity.class, LoginActivity.class};

    int type = 0;

    @Override
    protected Class<SuccessDelegate> getDelegateClass() {
        return SuccessDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        type = getIntent().getIntExtra(StaticFinal.INTENT_TYPE, 0);
        initToolbar(new ToolbarBuilder().setTitle(toolTitle[type]));
        viewDelegate.viewHolder.tv_title.setText(title[type]);
        viewDelegate.viewHolder.tv_content.setText(content[type]);
        viewDelegate.viewHolder.tv_tosat.setText(toast[type]);


        viewDelegate.setOnClickListener(this, R.id.tv_tosat);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_tosat:
                startActivity(new Intent(SuccessActivity.this, classes[type]));
                finish();
                break;
        }
    }

}
