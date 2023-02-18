package com.mammadli.to_do_app.services;

import com.mammadli.to_do_app.model.dto.TaskRequest;
import com.mammadli.to_do_app.model.entity.Task;
import com.mammadli.to_do_app.util.ResponseData;

import java.util.List;

public interface TaskServices {

    Task addTask(TaskRequest request);

    Task updateTask(TaskRequest request,String taskId);

    List<Task> getAllTasks(String idUser);

    Void deleteTask(String idUser, String id);
}
