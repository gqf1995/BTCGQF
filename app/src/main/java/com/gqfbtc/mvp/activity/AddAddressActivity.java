package com.gqfbtc.mvp.activity;

import com.fivefivelike.mybaselibrary.base.BaseDataBindActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.mvp.databinder.AddAddressBinder;
import com.gqfbtc.mvp.delegate.AddAddressDelegate;


public class AddAddressActivity extends BaseDataBindActivity<AddAddressDelegate, AddAddressBinder> {


    @Override
    protected Class<AddAddressDelegate> getDelegateClass() {
        return AddAddressDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("添加BTC地址").setSubTitle("帮助"));
    }

    @Override
    public AddAddressBinder getDataBinder(AddAddressDelegate viewDelegate) {
        return new AddAddressBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }
}
