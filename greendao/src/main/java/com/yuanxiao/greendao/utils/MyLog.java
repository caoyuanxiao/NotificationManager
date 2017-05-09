package com.yuanxiao.greendao.utils;

import android.util.Log;

import com.yuanxiao.greendao.BuildConfig;

/**
 * Created by kc on 17/5/9.
 */

public class MyLog {
    private static final String TAG = "MyLog";

    public static void showLog() {
        if (BuildConfig.IS_SHOW_LOG) {
            Log.i(TAG, "showLog: 我是Debug模式");
        } else {
            Log.i(TAG, "showLog: 我是releash模式");
        }
    }
}
