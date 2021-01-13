package com.adam.todolist.module.network;

import android.content.Context;
import android.content.SharedPreferences;

import com.adam.todolist.data.User;
import com.google.gson.Gson;

public class SPManager {
    private Context context;

    private final int PRIVATE_MODE = 0;
    private final String PREFERENCES_NAME = "ADAM_TODOLIST";

    private final String TOKEN_KEY = "TOKEN";
    private final String LOGGED_IN_USER_KEY = "USER";

    public SPManager (Context context) {
        this.context = context;
    }

    private SharedPreferences.Editor getEditor () {
        SharedPreferences sharedPreferences = getSharedPreferences();
        return sharedPreferences.edit();
    }

    private SharedPreferences getSharedPreferences () {
        return context.getSharedPreferences(PREFERENCES_NAME, PRIVATE_MODE);
    }

    public void setToken (String token) {
        SharedPreferences.Editor editor = getEditor();

        editor.putString(TOKEN_KEY, token);
        editor.commit();
    }

    public String getToken () {
        SharedPreferences sharedPreferences = getSharedPreferences();

        return sharedPreferences.getString(TOKEN_KEY, null);
    }

    public void setLoggedInUser (User user) {
        SharedPreferences.Editor editor = getEditor();

        Gson gson = new Gson();
        String userGson = gson.toJson(user);

        editor.putString(LOGGED_IN_USER_KEY, userGson);
        editor.commit();
    }

    public User getLoggedInUser () {
        SharedPreferences sharedPreferences = getSharedPreferences();

        String userGson = sharedPreferences.getString(LOGGED_IN_USER_KEY, null);

        Gson gson = new Gson();

        // Should i just convert those null string into User or nah? idk
        if (userGson == null) {
            return null;
        } else {
            return (User) gson.fromJson(userGson, User.class);
        }

    }
}
