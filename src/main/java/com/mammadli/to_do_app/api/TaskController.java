package com.mammadli.to_do_app.api;

import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.services.TaskServices;
import com.mammadli.to_do_app.services.UserServices;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskServices taskServices;
    private final UserServices userServices;


    @PostMapping("/{idUser}")
    ResponseEntity<Task> addTask(@PathVariable String idUser, @RequestBody Task task){
        return ResponseEntity.ok(taskServices.addTask(idUser,task));
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable String id){
        return ResponseEntity.ok(taskServices.updateTask(id));
    }

    @GetMapping("/get-list/{idUser}")
    ResponseEntity<List<Task>> getAllTasks(@PathVariable String idUser){
        return ResponseEntity.ok(taskServices.getAllTasks(idUser));
    }

//    @DeleteMapping()
//    ResponseEntity<Void> deleteTask(@PathVariable String idUser, String id){
//        return ResponseEntity.ok(taskServices.deleteTask(idUser,id));
//    }


}
