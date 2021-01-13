package com.adam.todolist.module.detail;

import com.adam.todolist.data.Task;
import com.adam.todolist.module.base.BasePresenter;
import com.adam.todolist.module.base.BaseView;

public interface DetailContract {
    interface Presenter extends BasePresenter {
        void fetchTaskDetail(int taskID);
    }

    interface View extends BaseView<DetailContract.Presenter> {
        void setDetailData(Task task);
    }
}
