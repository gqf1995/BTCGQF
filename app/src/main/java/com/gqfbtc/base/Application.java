package com.gqfbtc.base;

import android.app.Activity;

import com.blankj.utilcode.util.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 郭青枫 on 2017/9/25.
 */

public class Application extends android.app.Application {
    private static Application instance;

    public static synchronized Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化工具类集合
        Utils.init(this);


        //        //画廊网络加载图片
        //        Album.initialize(
        //                AlbumConfig.newBuilder(this)
        //                        .setAlbumLoader(new GlideAlbumLoader()) // Set album load.
        //                        .setLocale(Locale.ENGLISH) // For example, Fixed display language is English.
        //                        .build()
        //        );
        //        GlobleContext.init(this);
        //
        //        //初始化nohttp
        //        NoHttp.initialize(this);
        //
        //        //初始化数据库
        //        DaoManager.getInstance().init(this);
    }


    //    public static void Logout() {
    //        HttpUrl.getIntance().delectUidAndToken();
    //        SingSettingDBUtil.logout();
    //    }

    /**
     * OnLowMemory是Android提供的API，在系统内存不足，
     * 所有后台程序（优先级为background的进程，不是指后台运行的进程）都被杀死时，系统会调用OnLowMemory
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //垃圾回收
        System.gc();
    }

    /**
     * 打开的activity
     **/
    private List<Activity> activities = new ArrayList<Activity>();

    /**
     * 新建了一个activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
                activity = null;
            }
        }
        System.exit(0);
    }

    /**
     * 关闭Activity列表中的所有Activity
     */
    public void finishActivity() {
        for (Activity activity : activities) {
            if (null != activity) {
                activity.finish();
            }
        }
        //杀死该应用进程
        //android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 关闭除传参页面所有的activity
     */
    public void finishActivity(Class c) {
        for (Activity activity : activities) {
            if (null != activity) {
                if (activity.getClass() != c) {
                    activity.finish();
                    activity = null;
                }
            }
        }
    }

}
