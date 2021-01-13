package com.adam.todolist.module.newTask;

import com.adam.todolist.module.base.BasePresenter;
import com.adam.todolist.module.base.BaseView;

public interface NewTaskContract {
    interface Presenter extends BasePresenter {
        //void fetchTaskDetail(int taskID);
    }

    interface View extends BaseView<NewTaskContract.Presenter> {
        void setPresenter(Presenter presenter);
        //void setDetailData(Task task);
    }
}
