package com.mammadli.to_do_app.services;

import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.util.ResponseData;

import java.util.List;

public interface TaskServices {

    ResponseData<Task> addTask(Task task);

    ResponseData<Task> updateTask(String id);

    ResponseData<List<Task>> getAllTasks(String idUser);

//    ResponseData<String> deleteTask(String idUser, String id);
}
