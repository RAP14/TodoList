package com.adam.todolist.module.newTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adam.todolist.R;

public class NewTaskFragment extends Fragment implements NewTaskContract.View{
    private NewTaskPresenter presenter;

    private EditText namaTE;
    private EditText descTE;
    private Button createButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_newtask, container, false);

        return customView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);

        Intent intent = getActivity().getIntent();

        namaTE = view.findViewById(R.id.nama_textedit);
        descTE = view.findViewById(R.id.desc_textedit);
        createButton = view.findViewById(R.id.create_btn);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateButtonClick();
            }
        });

        setPresenter(new NewTaskPresenter(this, getContext()));
    }

    void onCreateButtonClick() {
        String nama = namaTE.getText().toString();
        String desc = descTE.getText().toString();
        presenter.createTask(nama, desc);
    }

    @Override
    public void setPresenter(NewTaskContract.Presenter presenter) {
        this.presenter = (NewTaskPresenter) presenter;
    }

    @Override
    public void navigateToActivity(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }
}
