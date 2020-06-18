package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Toast.makeText(context,"ACTION_BOOT_COMPLETED ",Toast.LENGTH_SHORT).show();
        }else if (intent.getAction().equals(Intent.ACTION_TIMEZONE_CHANGED)){
            Toast.makeText(context,"ACTION_TIMEZONE_CHANGED",Toast.LENGTH_LONG).show();

        }

    }
}
