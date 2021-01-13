package com.adam.todolist.module.network;

import com.adam.todolist.data.LoginRequest;
import com.adam.todolist.data.LoginResult;
import com.adam.todolist.data.Task;
import com.adam.todolist.data.TaskRequest;
import com.adam.todolist.data.TaskResult;
import com.adam.todolist.data.TasksResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APICall {
    @POST("/login/mobile")
    public Call<LoginResult> attemptLogin(@Body LoginRequest request);

    @GET("/task")
    public Call<TasksResult> getTasks();

    @GET("/task/{id}")
    public Call<TaskResult> getTask(@Path("id") int taskID);

    @POST("/task")
    public Call<TaskResult> createTask(); // kudune ada body e

    @PUT("/task/{id}")
    public Call<TaskResult> updateTask(@Path("id") int taskID, @Body TaskRequest request); // kudune ada body e

    @DELETE("/task/{id}")
    public Call<TaskResult> deleteTask(@Path("id") int taskID);
}
