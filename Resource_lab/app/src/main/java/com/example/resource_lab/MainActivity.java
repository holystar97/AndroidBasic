package com.example.resource_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String[] animals;
    private ImageView Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Image=(ImageView)findViewById(R.id.image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.item1:
                new AlertDialog.Builder(this)
                        .setTitle("Select Animals")
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setItems(R.array.animal,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                animals = getResources().getStringArray(R.array.animal);
                                Toast.makeText(getApplicationContext(), animals[which], Toast.LENGTH_SHORT).show();
                                imgLoad(animals[which]);
                                dialog.dismiss();
                            }
                        })
                        .create().show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void imgLoad(String animal){
        Animation anim= null;
        if(animal.equals("사자")){
            Image.setImageResource(R.drawable.lion);
            anim= AnimationUtils.loadAnimation(this,R.anim.scale);
        }
        else if(animal.equals("호랑이")){
            Image.setImageResource(R.drawable.tiger);
            anim= AnimationUtils.loadAnimation(this,R.anim.scale);
        }
        else if(animal.equals("기린")){
            Image.setImageResource(R.drawable.giraffe);
            anim= AnimationUtils.loadAnimation(this,R.anim.scale);
        }
        Image.startAnimation(anim);
    }




}
