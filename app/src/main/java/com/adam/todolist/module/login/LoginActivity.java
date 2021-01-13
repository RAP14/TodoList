package com.adam.todolist.module.login;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.adam.todolist.R;
import com.adam.todolist.module.base.BaseActivity;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        setCurrentFragment(new LoginFragment());
    }
}
