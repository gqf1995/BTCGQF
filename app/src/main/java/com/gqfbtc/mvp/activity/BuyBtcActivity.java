package com.gqfbtc.mvp.activity;

import android.content.Intent;
import android.view.View;

import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.gqfbtc.R;
import com.gqfbtc.mvp.delegate.BuyBtcDelegate;


public class BuyBtcActivity extends BaseActivity<BuyBtcDelegate> {


    @Override
    protected Class<BuyBtcDelegate> getDelegateClass() {
        return BuyBtcDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("买BTC").setSubTitle("帮助"));
        viewDelegate.setOnClickListener(this, R.id.tv_anquan_commit, R.id.tv_putong_commit, R.id.tv_anquan_more, R.id.tv_putong_more);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_anquan_commit:
                startActivity(new Intent(BuyBtcActivity.this, BuyAndSellActivity.class));
                break;
            case R.id.tv_putong_commit:
                startActivity(new Intent(BuyBtcActivity.this, BuyAndSellActivity.class));
                break;
            case R.id.tv_anquan_more:
                break;
            case R.id.tv_putong_more:
                break;
        }
    }
}
