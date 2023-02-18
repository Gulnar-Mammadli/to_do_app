package com.mammadli.to_do_app.api;

import com.mammadli.to_do_app.model.dto.TaskRequest;
import com.mammadli.to_do_app.model.entity.Task;
import com.mammadli.to_do_app.services.TaskServices;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "http://localhost:8080"})
public class TaskController {

    private final TaskServices taskServices;


    @PostMapping("/add")
    Task addTask(@RequestBody TaskRequest request) {
        return taskServices.addTask(request);
    }

    //    TODO update this method
    @PutMapping("/update/{taskId}")
    Task updateTask(@RequestBody TaskRequest request, String taskId) {
        return taskServices.updateTask(request, taskId));
    }

    @GetMapping("/get-list/{idUser}")
    List<Task> getAllTasks(@PathVariable String idUser) {
        return taskServices.getAllTasks(idUser);
    }

    @DeleteMapping("/{idUser}/{id}")
    Void deleteTask(@PathVariable String idUser, @PathVariable String id) {
        return taskServices.deleteTask(idUser, id);
    }


}
