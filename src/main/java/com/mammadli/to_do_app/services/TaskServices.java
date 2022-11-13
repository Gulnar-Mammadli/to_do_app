package com.mammadli.to_do_app.services;

import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.util.ResponseData;

import java.util.List;

public interface TaskServices {

    Task addTask(String idUser, Task task);

    Task updateTask(String id);

    List<Task> getAllTasks(String idUser);

    void deleteTask(String idUser, String id);
}
