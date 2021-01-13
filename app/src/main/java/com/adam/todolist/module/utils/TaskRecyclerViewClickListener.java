package com.adam.todolist.module.utils;

public interface TaskRecyclerViewClickListener {
    void navigateToActivity(int taskId);
    void showSomething();
    void updateCheckedState(int taskId, boolean isTaskChecked);
}
