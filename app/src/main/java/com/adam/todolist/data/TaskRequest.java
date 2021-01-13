package com.adam.todolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskRequest {
    @SerializedName("task")
    @Expose
    private Task task;

    public void setTask(Task task) {
        this.task = task;
    }
    public Task getTask() {
        return task;
    }

}
