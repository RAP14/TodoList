package com.adam.todolist.module.login;

import com.adam.todolist.module.base.BasePresenter;
import com.adam.todolist.module.base.BaseView;

public interface LoginContract {
    interface LoginPresenter extends BasePresenter {
        void attemptLogin(String email, String password);
    }

    interface LoginView extends BaseView<LoginPresenter> {
    }
}
