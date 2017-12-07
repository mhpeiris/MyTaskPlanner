package com.example.hareen.mytaskplanner;

/**
 * Created by Ibrahim on 11/11/2017.
 */

public class Task {


    public String task;
    public double completionTime;
    public String date;

    //Constructor
    public Task(String mTask, double mCompletionTime, String mDate){
        super();

        task = mTask;
        completionTime = mCompletionTime;
        date = mDate;
    }


    public String getTask() {
        return task;
    }

    public double getCompletionTime() {
        
        return completionTime;
    }
    public String getTaskDate() {
        return date;
    }
}
