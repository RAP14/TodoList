package com.adam.todolist.module.base;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.adam.todolist.R;

public class BaseActivity extends AppCompatActivity {
    public void setCurrentFragment(Fragment fragment) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_frame, fragment)
                .commit();
    }
}
