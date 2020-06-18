package com.example.datasave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.datasave.databinding.ActivityMainBinding;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLoad.setOnClickListener(v->load());
        binding.btnSave.setOnClickListener(v->save());
    }

    void load(){
        File file= new File(getFilesDir(),"app.txt");

        SharedPreferences pref=getSharedPreferences("pref",MODE_PRIVATE);
        String str=pref.getString("name","");
        binding.editText.setText(str);

    }

    void save(){
        File file=new File(getFilesDir(),"app.txt");
        SharedPreferences.Editor editor=getSharedPreferences("pref",0).edit();

        String value=binding.editText.getText().toString();

        editor.putString("name",value);
        editor.apply();
    }


}
