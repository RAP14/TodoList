package com.adam.todolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Ku tak tau kenapa namanya Task, ini generated ~
public class Task {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("cheked")
    @Expose
    private Integer cheked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCheked() {
        return cheked;
    }

    public void setCheked(Integer cheked) {
        this.cheked = cheked;
    }

}
