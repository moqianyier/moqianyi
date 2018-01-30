package com.moqianyi.aidlservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by moqianyi on 2017/9/11.
 */

public class BaseActivity extends FragmentActivity{

    protected MyService myService;
    private boolean isBound = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.PlayBinder playBinder = (MyService.PlayBinder) service;
            myService = playBinder.getMyService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
            isBound = false;
        }
    };

    //绑定服务
    public void bindMyService(){
        if (isBound == false) {
            Intent intent = new Intent(this,MyService.class);
            bindService(intent,conn, Context.BIND_AUTO_CREATE);
            isBound = true;
        }
    }

    //解绑服务
    public void unbindMyService(){
        if (isBound == true) {
            unbindService(conn);
        }
    }
}
