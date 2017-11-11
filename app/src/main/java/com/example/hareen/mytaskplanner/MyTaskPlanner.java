package com.example.hareen.mytaskplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;

public class MyTaskPlanner extends AppCompatActivity {

    EditText the_task;
    EditText the_time;
    TextView show_task;
    FloatingActionButton addTaskBtn;
    Button mBtLaunchActivity;
    String taskString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task_planner);

        the_task = (EditText) findViewById(R.id.task);
        the_time = (EditText) findViewById(R.id.completionTime);
        show_task = (TextView) findViewById(R.id.result);
        addTaskBtn = (FloatingActionButton) findViewById(R.id.add_plus_btn);
        addTaskBtn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                taskString = the_task.getText().toString();
                show_task.setText(taskString);
            }
        });
        mBtLaunchActivity = (Button) findViewById(R.id.bt_launch_activity);

        mBtLaunchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
    }
    private void launchActivity() {

        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

}
