package com.gqfbtc.mvp.fragment;

import com.fivefivelike.mybaselibrary.base.BaseFragment;
import com.gqfbtc.mvp.delegate.CustomerServiceDelegate;


public class CustomerServiceFragment extends BaseFragment<CustomerServiceDelegate> {


    @Override
    protected Class<CustomerServiceDelegate> getDelegateClass() {
        return CustomerServiceDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }
}
