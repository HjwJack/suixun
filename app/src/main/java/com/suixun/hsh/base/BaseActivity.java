package com.suixun.hsh.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.suixun.hsh.utils.Logger;
import com.suixun.hsh.utils.ToastUtil;


public class BaseActivity extends AppCompatActivity {

    private static String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
    }

    //Toast
    protected void showToast(String msg) {
        ToastUtil.showToast(this, msg, Toast.LENGTH_LONG);
    }

    //Log
    protected void showLog(String msg) {
        Logger.showLog(TAG, msg, Log.INFO);
    }

    //Intent Activity
    protected void intent2Activity(Class<? extends Activity> clazz) {
        Intent intent=new Intent(this,clazz);
        startActivity(intent);
    }


}
