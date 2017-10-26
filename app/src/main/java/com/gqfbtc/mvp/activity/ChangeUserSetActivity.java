package com.gqfbtc.mvp.activity;

import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.mvp.delegate.ChangeUserSetDelegate;


public class ChangeUserSetActivity extends BaseActivity<ChangeUserSetDelegate> {


    @Override
    protected Class<ChangeUserSetDelegate> getDelegateClass() {
        return ChangeUserSetDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("标题").setSubTitle("帮助"));
    }
}
