package com.mammadli.to_do_app.model;

import com.mammadli.to_do_app.model.entity.Task;
import com.mammadli.to_do_app.enums.TaskStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,String> {

    Task findByIdUserAndId(String IdUser, String id);
    Task findByIdUserAndIdAndTaskStatus(String idUser, String id, TaskStatus taskStatus);
    List<Task> findAllByIdUserAndTaskStatus(String idUser, TaskStatus taskStatus);


}
