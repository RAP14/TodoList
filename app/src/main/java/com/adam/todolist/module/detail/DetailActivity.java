package com.adam.todolist.module.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.adam.todolist.R;
import com.adam.todolist.module.base.BaseActivity;
import com.adam.todolist.module.dashboard.DashboardFragment;
import com.adam.todolist.module.login.LoginFragment;

public class DetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        setCurrentFragment(new DetailFragment());
    }
}
