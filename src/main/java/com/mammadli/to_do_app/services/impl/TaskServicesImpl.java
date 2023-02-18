package com.mammadli.to_do_app.services.impl;

import com.mammadli.to_do_app.mapper.TaskMapper;
import com.mammadli.to_do_app.model.TaskRepository;
import com.mammadli.to_do_app.model.UserRepository;
import com.mammadli.to_do_app.model.dto.TaskRequest;
import com.mammadli.to_do_app.model.entity.Task;
import com.mammadli.to_do_app.model.entity.User;
import com.mammadli.to_do_app.enums.TaskStatus;
import com.mammadli.to_do_app.services.TaskServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServicesImpl implements TaskServices {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Task addTask(TaskRequest request) {
        User user = userRepository.findByIdUser(request.getIdUser());
        if (user != null) {
            request.setTaskStatus(TaskStatus.CREATED);
            return taskRepository.save(TaskMapper.INSTANCE.mapToTask(request));
        }
        return null;
    }

    @Override
    public Task updateTask(TaskRequest request, String taskId) {
        User user = userRepository.findByIdUser(request.getIdUser());
        if (user != null) {
            Task response = taskRepository.findByIdUserAndIdAndTaskStatus(request.getIdUser(), taskId, TaskStatus.CREATED);
            if (response != null) {
                return taskRepository.save(response);
            }
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks(String idUser) {
        List<Task> tasks = taskRepository.findAllByIdUserAndTaskStatus(idUser, TaskStatus.CREATED);
        if (!tasks.isEmpty()) {
            return tasks;
        }
        return null;
    }

    @Override
    public Void deleteTask(String idUser, String id) {
        Task task = taskRepository.findByIdUserAndId(idUser, id);
        if (task != null) {
            task.setTaskStatus(TaskStatus.DELETED);
            taskRepository.save(task);
        }
        return null;
    }
}
