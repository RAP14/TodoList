package com.adam.todolist.module.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adam.todolist.R;
import com.adam.todolist.module.detail.DetailActivity;
import com.adam.todolist.module.utils.TaskRecyclerViewClickListener;
import com.adam.todolist.module.utils.TaskRecyclerViewAdapter;

public class DashboardFragment extends Fragment implements DashboardContract.View, TaskRecyclerViewClickListener {
    public RecyclerView taskRecyclerView;
    public DashboardPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        return customView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TaskRecyclerViewAdapter adapter = new TaskRecyclerViewAdapter(this);

        presenter = new DashboardPresenter(this, adapter, getContext());

        taskRecyclerView = view.findViewById(R.id.task_recyclerview);

        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        taskRecyclerView.setAdapter(adapter);

        presenter.fetchTaskList();
    }

    @Override
    public void setPresenter(DashboardPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToActivity(Class activityClass) {

    }

    @Override
    public void navigateToActivity(int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("taskID", position);
        startActivity(intent);
    }

    @Override
    public void showSomething() {
        Toast.makeText(getContext(), "hehe", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateCheckedState(int position, boolean isChecked) {
        presenter.updateTaskCheckedState(position, isChecked);
    }
}
