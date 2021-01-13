package com.adam.todolist.module.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.adam.todolist.R;
import com.adam.todolist.data.Task;
import com.adam.todolist.module.base.BasePresenter;
import com.adam.todolist.module.dashboard.DashboardPresenter;
import com.adam.todolist.module.utils.TaskRecyclerViewAdapter;

public class DetailFragment extends Fragment implements DetailContract.View {
    private DetailPresenter presenter;
    private int taskID;

    private TextView taskNameTV;
    private TextView taskDescTV;
    private TextView taskDateTV;
    private TextView taskCheckedTV;
    private Button editButton;
    private Button deleteButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_detail, container, false);

        return customView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);

        Intent intent = getActivity().getIntent();
        taskID = intent.getIntExtra("taskID", 100);

        presenter = new DetailPresenter(this, getContext());

        taskNameTV = view.findViewById(R.id.detail_task_name_textview);
        taskDescTV = view.findViewById(R.id.detail_task_desc_textview);
        taskDateTV = view.findViewById(R.id.detail_task_date_textview);
        taskCheckedTV = view.findViewById(R.id.detail_task_checked_textview);

        presenter.fetchTaskDetail(taskID);
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {

    }

    @Override
    public void navigateToActivity(Class activityClass) {

    }

    @Override
    public void setDetailData(Task task) {
        taskNameTV.setText(task.getTitle());
        taskDescTV.setText(task.getDescription());
        taskDateTV.setText(task.getDescription());
        taskCheckedTV.setText(task.getCheked() == 1 ? "Finished" : "Not Finished");
    }
}
