package com.suixun.hsh.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者: hjw on 2017/6/27 18:28
 * 邮箱: 18910207853@163.com
 */

public class ToastUtil {
    private static Toast mToast;
    public static void showToast(Context context,String msg,int duration){
        if (mToast==null){
            mToast=Toast.makeText(context,msg,duration);
        }else{
            mToast.setText(msg);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
}
