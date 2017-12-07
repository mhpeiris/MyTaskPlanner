package com.example.hareen.mytaskplanner;


import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;


public class ScheduleActivity extends AppCompatActivity {

    private Button goBackBtn;
    private TextView dateText;
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;
    private FloatingActionButton addTaskBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        goBackBtn = (Button) findViewById(R.id.bt_go_back);
        mListView = (ListView) findViewById(R.id.listView);
        dateText = (TextView) findViewById(R.id.textView);
        mDatabaseHelper = new DatabaseHelper(this);
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            launchActivity();
            }
        });

        //Add a task  -  using Intent to start MyTaskPlanner activity
        addTaskBtn = (FloatingActionButton) findViewById(R.id.add_btn);
        addTaskBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(ScheduleActivity.this,MyTaskPlanner.class));
            }
        });
        populateListView();

    }
    private void launchActivity() {
        //Intent used to refresh the page
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }
    public void populateListView(){
        Calendar calendar;

        int year, month, day;
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        StringBuilder date = new StringBuilder().append(day).append("/")
                .append(month+1).append("/").append(year);
        String dateString = date.toString();
        //Get todays date
        dateText.setText(dateString);
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();

        //Check if the same date
        while (data.moveToNext()) {
            if (dateString.equals(data.getString(2)))
               listData.add(data.getString(1));
        }


        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }
}
