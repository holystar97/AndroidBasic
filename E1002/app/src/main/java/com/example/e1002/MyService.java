package com.example.e1002;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // onBind() 메서드 재정의 ; 바인더 객체 생성 그리고 리턴
        return new LocalBinder();
    }

    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
    public int CalcNum(int m, int n){
        return m*n;
    }

}
