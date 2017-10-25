package com.gqfbtc.mvp.activity;

import com.fivefivelike.mybaselibrary.base.BaseDataBindActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.mvp.databinder.AdvertisingBuyAndSellBinder;
import com.gqfbtc.mvp.delegate.AdvertisingBuyAndSellDelegate;


public class AdvertisingBuyAndSellActivity extends BaseDataBindActivity<AdvertisingBuyAndSellDelegate, AdvertisingBuyAndSellBinder> {


    @Override
    protected Class<AdvertisingBuyAndSellDelegate> getDelegateClass() {
        return AdvertisingBuyAndSellDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("买BTC").setSubTitle("帮助"));
    }

    @Override
    public AdvertisingBuyAndSellBinder getDataBinder(AdvertisingBuyAndSellDelegate viewDelegate) {
        return new AdvertisingBuyAndSellBinder(viewDelegate);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {

    }
}
