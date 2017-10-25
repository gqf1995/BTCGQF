package com.gqfbtc.mvp.activity;

import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.mvp.delegate.AddCollectionAddressDelegate;


public class AddCollectionAddressActivity extends BaseActivity<AddCollectionAddressDelegate> {


    @Override
    protected Class<AddCollectionAddressDelegate> getDelegateClass() {
        return AddCollectionAddressDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("添加收款地址").setSubTitle("帮助"));
    }
}
