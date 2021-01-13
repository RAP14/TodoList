package com.adam.todolist.module.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.adam.todolist.data.LoginRequest;
import com.adam.todolist.data.LoginResult;
import com.adam.todolist.module.base.BaseView;
import com.adam.todolist.module.dashboard.DashboardActivity;
import com.adam.todolist.module.network.APICall;
import com.adam.todolist.module.network.RetrofitClient;
import com.adam.todolist.module.network.SPManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.LoginPresenter {
    private BaseView view;
    private Context context;

    public LoginPresenter(LoginContract.LoginView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attemptLogin(String email, String password) {
        APICall apiService = RetrofitClient.getInstance().create(APICall.class);

        Call<LoginResult> call = apiService.attemptLogin(new LoginRequest(email, password));

        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call call, Response response) {

                if(response.isSuccessful()) {
                    LoginResult data = (LoginResult) response.body();

                    SPManager spManager = new SPManager(context);

                    spManager.setToken(data.getToken());
                    spManager.setLoggedInUser(data.getUser());

                    view.navigateToActivity(DashboardActivity.class);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                    Toast.makeText(context, "Login failed. Please try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
