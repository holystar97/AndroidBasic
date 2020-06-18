package com.example.service2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.example.service2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent =new Intent(MainActivity.this,MyService.class);
        bindService(intent,MainActivity.this,BIND_AUTO_CREATE);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myService != null){
                    int r= myService.calcNum(1,1);
                }
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        myService=((MyService.MyBinder)service).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        myService=null;
    }
}
