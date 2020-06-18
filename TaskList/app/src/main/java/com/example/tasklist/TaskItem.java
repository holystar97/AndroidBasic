package com.example.tasklist;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem {

    private boolean completed;
    private String title;
    private Date date;

    public TaskItem(boolean completed, String title, Date date){

        this.completed=completed;
        this.title=title;
        this.date=date;
    }

    public TaskItem(String title){
     this(false, title, new Date(java.lang.System.currentTimeMillis()));
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @NonNull
    @Override
    public String toString() {

        String completedString= ((completed == true) ? "X": "-" );
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM//dd/yy");
        String dateString=dateFormat.format(date);
        return "[" + completedString + " :"+dateString+"]"+title;
    }
}
