package com.mammadli.to_do_app.services.impl;

import com.mammadli.to_do_app.db.TaskRepository;
import com.mammadli.to_do_app.db.UserRepository;
import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.services.TaskServices;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServicesImpl implements TaskServices {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Task addTask(String idUser, Task task) {
        User user = userRepository.findUserByIdUser(idUser);
        if(user != null){
            Task new_task = taskRepository.save(task);
            return new_task;
        }
        return null;
    }

    @Override
    public Task updateTask(String id) {
        return null;
    }

    @Override
    public List<Task> getAllTasks(String idUser) {
        List<Task> tasks = taskRepository.findAllByIdUser(idUser);
        if(!tasks.isEmpty()){
            return tasks;
        }
        return null;
    }

    @Override
    public void deleteTask(String idUser, String id) {
        Task task = taskRepository.findByIdUser(idUser, id);
        if(task!=null){
            taskRepository.deleteById(id);
        }
    }
}
