package com.mammadli.to_do_app.db;

import com.mammadli.to_do_app.db.entity.Task;
import com.mammadli.to_do_app.enums.TaskStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,String> {

    Task findByIdUserAndId(String IdUser, String id);
    List<Task> findAllByIdUserAndTaskStatus(String idUser, TaskStatus taskStatus);


}
