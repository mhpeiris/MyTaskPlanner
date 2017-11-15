package com.example.hareen.mytaskplanner;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.widget.Toast;

import java.util.Calendar;

public class MyTaskPlanner extends AppCompatActivity {

    EditText the_task;
    EditText the_time;
    FloatingActionButton addTaskBtn;
    Button nextPageBtn;
    String taskString;
    int timeInt;
    String dateString;
    DatabaseHelper mDatabaseHelper;
    private Button goBackBtn;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private Task task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task_planner);

        the_task = (EditText) findViewById(R.id.task);
        the_time = (EditText) findViewById(R.id.completionTime);

        addTaskBtn = (FloatingActionButton) findViewById(R.id.add_plus_btn);
        mDatabaseHelper = new DatabaseHelper(this);

        //Button to add the task to the database
        addTaskBtn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                taskString = the_task.getText().toString();
                timeInt = Integer.parseInt(the_time.getText().toString());
                //Create the task
                 task = new Task(taskString, timeInt, dateString);
                AddData(task);
                Toast.makeText(MyTaskPlanner.this, "The task has been added!",
                        Toast.LENGTH_LONG).show();
            }
        });

        //Button to go to the schedule page
        nextPageBtn = (Button) findViewById(R.id.bt_launch_activity);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });

        //Setting the date
        dateView = (TextView) findViewById(R.id.date_textview);
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //Display date
        showDate(year, month+1, day);

    }


    //METHODS
    public void AddData(Task newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
    }



    private void launchActivity() {

        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
      StringBuilder date = new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year);
      dateString = date.toString();
      dateView.setText(dateString);
    }
}
