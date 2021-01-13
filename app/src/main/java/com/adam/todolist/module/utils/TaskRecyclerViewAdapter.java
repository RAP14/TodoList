package com.adam.todolist.module.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.adam.todolist.R;
import com.adam.todolist.data.Task;

import java.util.ArrayList;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder> {
    private ArrayList<Task> taskList;
    private TaskRecyclerViewClickListener navigationListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CheckBox taskCheckBox;
        public TextView taskName;

        public TaskViewHolder(View view) {
            super(view);
            taskCheckBox = view.findViewById(R.id.task_check_box);
            taskName = view.findViewById(R.id.task_name_textview);
        }
    }

    public TaskRecyclerViewAdapter(TaskRecyclerViewClickListener navigationListener) {
        this.taskList = new ArrayList<Task>();
        this.navigationListener = navigationListener;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TaskRecyclerViewAdapter.TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_view_holder, parent, false);

        TaskViewHolder vh = new TaskViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Task task = taskList.get(position);
        boolean isTaskChecked = task.getCheked() == 1;

        holder.taskName.setText(task.getTitle());
        holder.taskCheckBox.setChecked(isTaskChecked);

        holder.taskCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                navigationListener.updateCheckedState(task.getId(), !isTaskChecked);
                task.setCheked(!isTaskChecked ? 1 : 0);
            }
        });

        holder.itemView.setOnClickListener(v -> navigationListener.navigateToActivity(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return taskList.size();
    }
}