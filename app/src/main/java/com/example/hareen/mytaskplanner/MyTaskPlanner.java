package com.example.hareen.mytaskplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyTaskPlanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task_planner);
    }

    public void onClickUnblock(View v)
    {
        Button button = (Button) v;
        int x;
    }
}
