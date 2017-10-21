package com.gqfbtc.mvp.databinder;

import com.fivefivelike.mybaselibrary.base.BaseDataBind;
import com.fivefivelike.mybaselibrary.http.HttpRequest;
import com.fivefivelike.mybaselibrary.http.RequestCallback;
import com.gqfbtc.mvp.delegate.BaseActivityPullDelegate;


/**
 * Created by 郭青枫 on 2017/9/27.
 */

public class BaseActivityPullBinder extends BaseDataBind<BaseActivityPullDelegate> {
    public BaseActivityPullBinder(BaseActivityPullDelegate viewDelegate) {
        super(viewDelegate);
    }

}