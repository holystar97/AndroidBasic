package com.example.broadcastandreceiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.broadcastandreceiver.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MyBroadcastReceiver mReceiver;
    private final int RC_SMS_RECEIVED=1;
    public ListView listView;
    public ArrayList<String> data=new ArrayList<>();
    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView=binding.listView;
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

        mReceiver = new MyBroadcastReceiver();

        mReceiver.setOnSmsReceived(new MyBroadcastReceiver.OnSmsReceived(){
            @Override
            public void onReceived(String msg) {
                data.add(msg);
                adapter.notifyDataSetChanged();
            }
        });

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, RC_SMS_RECEIVED);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(mReceiver,new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mReceiver);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == RC_SMS_RECEIVED){

            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

            }else{
                new AlertDialog.Builder(this).setTitle("Permission!")
                         .setMessage("RECEIVE_SMS permission is required to receive SMS.\\nPress OK to grant the permission.")
                         .setPositiveButton("OK",((dialog, which) -> ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},RC_SMS_RECEIVED)))
                        .setNegativeButton("Cancel",null)
                        .create().show();
            }

        }
    }
}
