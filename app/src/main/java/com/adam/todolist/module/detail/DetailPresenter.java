package com.adam.todolist.module.detail;

import android.content.Context;
import android.widget.Toast;

import com.adam.todolist.data.Task;
import com.adam.todolist.data.TaskResult;
import com.adam.todolist.module.base.BaseView;
import com.adam.todolist.module.network.APICall;
import com.adam.todolist.module.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.View view;
    private Context context;

    public DetailPresenter(DetailContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void fetchTaskDetail(int taskID) {
        APICall apiService = RetrofitClient.getInstance().create(APICall.class);

        Call<TaskResult> call = apiService.getTask(taskID);

        call.enqueue(new Callback<TaskResult>() {
            @Override
            public void onResponse(Call call, Response response) {

                if(response.isSuccessful()) {
                    TaskResult taskResult = (TaskResult) response.body();

                    Task task = taskResult.getData();

                    view.setDetailData(task);
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
