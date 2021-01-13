package com.adam.todolist.module.dashboard;

import com.adam.todolist.data.Task;
import com.adam.todolist.module.base.BasePresenter;
import com.adam.todolist.module.base.BaseView;

import java.util.ArrayList;

public interface DashboardContract {
    interface Presenter extends BasePresenter {
        void fetchTaskList();
        void updateTaskCheckedState(int position, boolean isTaskChecked);
    }
    interface View extends BaseView<DashboardPresenter> {

    }

}
