package com.gqfbtc.mvp.activity;

import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.R;
import com.gqfbtc.mvp.delegate.WaitTransactDelegate;
import com.gqfbtc.mvp.fragment.CustomerServiceFragment;


public class WaitTransactActivity extends BaseActivity<WaitTransactDelegate> {


    @Override
    protected Class<WaitTransactDelegate> getDelegateClass() {
        return WaitTransactDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("待买家付款").setSubTitle("帮助"));
        initServiceFragment();
    }

    private void initServiceFragment() {
        viewDelegate.initAddFragment(R.id.fl_root, getSupportFragmentManager());
        viewDelegate.addFragment(new CustomerServiceFragment());
        viewDelegate.showFragment(0);
    }

}
