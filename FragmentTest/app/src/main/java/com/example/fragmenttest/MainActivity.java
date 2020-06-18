package com.example.fragmenttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                    switchFragment(0);
                return true;

            case R.id.item2:
                    switchFragment(1);
                return true;
        }
        return false;
    }

    void switchFragment(int num){

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        switch (num){
            case 0:
                ft.replace(R.id.fragment,new AFragment());
                break;
            case 1:
                ft.replace(R.id.fragment,new CFragment());

        }
        ft.commit();

    }


}
