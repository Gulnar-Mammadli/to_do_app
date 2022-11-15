package com.mammadli.to_do_app.services.impl;

import com.mammadli.to_do_app.db.TaskRepository;
import com.mammadli.to_do_app.db.UserRepository;
import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.enums.TaskStatus;
import com.mammadli.to_do_app.services.TaskServices;
import com.mammadli.to_do_app.util.GenerateResponseUtility;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServicesImpl implements TaskServices {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    public static int SUCCESS_CODE = 200;
    public static int ALREADY_EXIST_CODE = 409;
    public static int NOT_FOUND_CODE = 404;
    public static String SUCCESS_MESSAGE = "SUCCESS";
    public static String NOT_FOUND_MESSAGE = "NOT_FOUND";
    public static String ALREADY_EXIST_MESSAGE = "ALREADY EXIST";

    @Override
    public ResponseData<Task> addTask(String idUser, Task task) {
        User user = userRepository.findByIdUser(idUser);
        if(user != null){
            Task new_task = taskRepository.save(task);
            return GenerateResponseUtility.taskFunc.generate(SUCCESS_CODE,SUCCESS_MESSAGE,new_task);
        }
        return GenerateResponseUtility.taskFunc.generate(NOT_FOUND_CODE,NOT_FOUND_MESSAGE,null);
    }

    @Override
    public ResponseData<Task> updateTask(String id) {
        return null;
    }

    @Override
    public ResponseData<List<Task>> getAllTasks(String idUser) {
        List<Task> tasks = taskRepository.findAllByIdUser(idUser);
        if(!tasks.isEmpty()){
            return GenerateResponseUtility.tasksFunc.generate(SUCCESS_CODE,SUCCESS_MESSAGE,tasks);
        }
        return GenerateResponseUtility.tasksFunc.generate(NOT_FOUND_CODE,NOT_FOUND_MESSAGE,null);
    }

    @Override
    public ResponseData<String> deleteTask(String idUser, String id) {
        Task task = taskRepository.findByIdUser(idUser, id);
        if(task!=null){
            task.setTaskStatus(TaskStatus.DELETED);
            return GenerateResponseUtility.func.generate(SUCCESS_CODE,SUCCESS_MESSAGE,null);
        }
        return GenerateResponseUtility.func.generate(NOT_FOUND_CODE,NOT_FOUND_MESSAGE,null);
    }
}
