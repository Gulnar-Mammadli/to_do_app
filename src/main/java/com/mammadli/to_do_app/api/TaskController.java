package com.mammadli.to_do_app.api;

import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.services.TaskServices;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping
@RestController("/api/v1/tasks")
public class TaskController {

    private final TaskServices taskServices;


    @PostMapping("/{idUser}")
    ResponseEntity<ResponseData<Task>> addTask(@PathVariable String idUser, @RequestBody Task task){
        return ResponseEntity.ok(taskServices.addTask(idUser,task));
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseData<Task>> updateTask(@RequestBody Task task, @PathVariable String id){
        return ResponseEntity.ok(taskServices.updateTask(id));
    }

    @GetMapping("/get-list/{idUser}")
    ResponseEntity<ResponseData<List<Task>>> getAllTasks(@PathVariable String idUser){
        return ResponseEntity.ok(taskServices.getAllTasks(idUser));
    }

//    @DeleteMapping("/{idUser}/{id}")
//    ResponseEntity<ResponseData<String>> deleteTask(@PathVariable String idUser,@PathVariable String id){
//        return ResponseEntity.ok(taskServices.deleteTask(idUser, id));
//    }


}
