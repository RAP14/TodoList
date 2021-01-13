package com.adam.todolist.module.base;

import android.app.Activity;

public interface BaseView<T> {
    void setPresenter(T presenter);
    void navigateToActivity(Class activityClass);
}
