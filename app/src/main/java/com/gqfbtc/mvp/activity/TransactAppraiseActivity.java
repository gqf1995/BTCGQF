package com.gqfbtc.mvp.activity;

import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.mvp.delegate.TransactAppraiseDelegate;


public class TransactAppraiseActivity extends BaseActivity<TransactAppraiseDelegate> {


    @Override
    protected Class<TransactAppraiseDelegate> getDelegateClass() {
        return TransactAppraiseDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("交易评价").setSubTitle("帮助"));
    }



}
