package com.adam.todolist.module.newTask;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.adam.todolist.R;
import com.adam.todolist.module.base.BaseActivity;

public class NewTaskActivity extends BaseActivity{
    protected void onCreate(Bundle savedIntances){
        super.onCreate(savedIntances);
        setContentView(R.layout.activity_base);
        setCurrentFragment(new NewTaskFragment());
    }
}
