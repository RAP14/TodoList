package com.adam.todolist.module.newTask;

import android.content.Context;
import android.widget.Toast;

import com.adam.todolist.data.Task;
import com.adam.todolist.data.TaskRequest;
import com.adam.todolist.data.TaskResult;
import com.adam.todolist.module.dashboard.DashboardActivity;
import com.adam.todolist.module.network.APICall;
import com.adam.todolist.module.network.RetrofitClient;
import com.adam.todolist.module.network.SPManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewTaskPresenter implements  NewTaskContract.Presenter{
    private NewTaskContract.View view;
    private Context context;

    public NewTaskPresenter(NewTaskContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void createTask(String nama, String desc){

        TaskRequest taskRequest = new TaskRequest();
        Task task = new Task();
        task.setTitle(nama);
        task.setDescription(desc);
        taskRequest.setTask(task);

        APICall apiService = RetrofitClient.getInstance().create(APICall.class);
        Call<TaskResult> call = apiService.createTask(taskRequest);
        call.enqueue(new Callback<TaskResult>() {

            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()) {
                    view.navigateToActivity(DashboardActivity.class);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(context, "Create failed. Please try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
