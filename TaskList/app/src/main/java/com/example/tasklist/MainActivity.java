package com.example.tasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final private int MENU_ADD = Menu.FIRST;
    static final private int MENU_REMOVE=Menu.FIRST+1;

    private boolean inputNow=false;
    private TextView NoneTextView = null;
    private EditText TastEditText=null;
    private ListView TaskListView =null;
    private ArrayList<TaskItem> arrTaskItems=null;
    private ArrayAdapter<TaskItem> arrAdapter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
