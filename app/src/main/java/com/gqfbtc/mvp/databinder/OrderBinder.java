package com.gqfbtc.mvp.databinder;

import com.fivefivelike.mybaselibrary.base.BaseDataBind;
import com.gqfbtc.mvp.delegate.HomeDelegate;
import com.gqfbtc.mvp.delegate.OrderDelegate;

/**
 * Created by 郭青枫 on 2017/10/14.
 */

public class OrderBinder extends BaseDataBind<OrderDelegate> {
    public OrderBinder(OrderDelegate viewDelegate) {
        super(viewDelegate);
    }
}