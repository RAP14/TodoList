package com.adam.todolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("user")
    @Expose
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }

    public LoginRequest(String email, String password) {
        this.user = new User();
        user.setPassword(password);
        user.setEmail(email);
    }
}
