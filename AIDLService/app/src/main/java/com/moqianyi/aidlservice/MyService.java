package com.moqianyi.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    public MyService() {
    }

    public int getInt(){
        return 1;
    }

    class PlayBinder extends Binder{

        public MyService getMyService(){

            return MyService.this;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new PlayBinder();
    }
}
