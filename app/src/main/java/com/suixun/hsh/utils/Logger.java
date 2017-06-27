package com.suixun.hsh.utils;

import android.util.Log;

import com.suixun.hsh.contants.CommonContants;

/**
 * 作者: hjw on 2017/6/27 18:33
 * 邮箱: 18910207853@163.com
 */

public class Logger {
    public static void showLog(String TAG, String msg, int level) {
        if (!CommonContants.isShowLog) {
            return;
        }
        switch (level) {
            case Log.DEBUG:
                Log.d(TAG, msg);
                break;
            case Log.ERROR:
                Log.e(TAG, msg);
                break;
            case Log.INFO:
                Log.i(TAG, msg);
                break;
            case Log.VERBOSE:
                Log.v(TAG, msg);
                break;
            case Log.WARN:
                Log.w(TAG, msg);
                break;
            default:
                Log.i(TAG, msg);
        }
    }
}
