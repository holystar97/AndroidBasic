package com.example.pbl_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int red, blue, green;
    public static RadioGroup rg;
    public static int mSelect = 0;
    public static int mSelect2=0;
    public  static String[] colors;
    public  static String[] widths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.radioGroup);
        red = R.id.button_red;
        blue = R.id.button_blue;
        green = R.id.button_green;
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
                new AlertDialog.Builder(this)
                        .setTitle("색을 변경합니다.")
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setSingleChoiceItems(R.array.color, mSelect, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSelect = which;
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                colors = getResources().getStringArray(R.array.color);
                                Toast.makeText(getApplicationContext(), "선택한 색깔 = " + colors[mSelect], Toast.LENGTH_SHORT).show();
                                MyView.send(colors[mSelect]);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                return true;

            case R.id.item2:
                new AlertDialog.Builder(this)
                        .setTitle("붓모양을 변경합니다.")
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setSingleChoiceItems(R.array.width, mSelect2, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSelect2 = which;
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                widths = getResources().getStringArray(R.array.width);
                                Toast.makeText(getApplicationContext(), "선택한 붓모양 = " + widths[mSelect2], Toast.LENGTH_SHORT).show();
                                MyView.send2(widths[mSelect2]);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                return true;
        }

                return false;
             }
        }