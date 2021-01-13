package com.adam.todolist.module.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adam.todolist.R;
import com.adam.todolist.module.base.BaseView;
import com.adam.todolist.module.dashboard.DashboardActivity;

public class LoginFragment extends Fragment implements LoginContract.LoginView {
    LoginPresenter presenter;
    EditText emailTE;
    EditText passwordTE;
    Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_login, container, false);

        return customView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailTE = view.findViewById(R.id.email_textedit);
        passwordTE = view.findViewById(R.id.password_textedit);
        loginButton = view.findViewById(R.id.login_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });

        setPresenter(new LoginPresenter(this, getContext()));
    }

    void onLoginButtonClick() {
        String email = emailTE.getText().toString();
        String password = passwordTE.getText().toString();

        presenter.attemptLogin(email, password);
    }



    @Override
    public void setPresenter(LoginContract.LoginPresenter presenter) {
        this.presenter = (LoginPresenter) presenter;
    }

    @Override
    public void navigateToActivity(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }
}
