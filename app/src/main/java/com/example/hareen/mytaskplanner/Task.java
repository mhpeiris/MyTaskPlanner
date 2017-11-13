package com.example.hareen.mytaskplanner;

/**
 * Created by Ibrahim on 11/11/2017.
 */

public class Task {


    public String task;
    public int completionTime;
    public String date;

    public Task(String mTask, int mCompletionTime, String mDate){
        super();

        task = mTask;
        completionTime = mCompletionTime;
        date = mDate;
    }

    public String getTask() {
        return task;
    }

    public int getCompletionTime() {
        
        return completionTime;
    }
    public String getTaskDate() {
        return date;
    }
}
