package com.adam.todolist.module.dashboard;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.adam.todolist.data.LoginRequest;
import com.adam.todolist.data.LoginResult;
import com.adam.todolist.data.Task;
import com.adam.todolist.data.TaskRequest;
import com.adam.todolist.data.TaskResult;
import com.adam.todolist.data.TasksResult;
import com.adam.todolist.module.base.BaseView;
import com.adam.todolist.module.network.APICall;
import com.adam.todolist.module.network.RetrofitClient;
import com.adam.todolist.module.utils.TaskRecyclerViewAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardPresenter implements DashboardContract.Presenter {
    private BaseView view;
    private TaskRecyclerViewAdapter adapter;
    private Context context;

    public DashboardPresenter(DashboardContract.View view, TaskRecyclerViewAdapter adapter, Context context) {
        this.view = view;
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    public void fetchTaskList() {
        APICall apiService = RetrofitClient.getInstance().create(APICall.class);
        Call<TasksResult> call = apiService.getTasks();

        call.enqueue(new Callback<TasksResult>() {
            @Override
            public void onResponse(Call call, Response response) {

                if(response.isSuccessful()) {
                    TasksResult tasksResult = (TasksResult) response.body();

                    ArrayList<Task> taskList = (ArrayList<Task>) tasksResult.getData();

                    adapter.setTaskList(taskList);

                    Toast.makeText(context, "Data fetched", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(context, "Failed to fetch data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void updateTaskCheckedState(int position, boolean isTaskChecked) {
        Task task = new Task();
        task.setCheked(isTaskChecked ? 1 : 0);

        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTask(task);

        APICall apiService = RetrofitClient.getInstance().create(APICall.class);

        Call<TaskResult> call = apiService.updateTask(position, taskRequest);

        call.enqueue(new Callback<TaskResult>() {
            @Override
            public void onResponse(Call call, Response response) {

                if(response.isSuccessful()) {
                    adapter.notifyItemChanged(position - 1);
                    Toast.makeText(context, "Data updated", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(context, "Failed to fetch data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
