package com.mammadli.to_do_app.model.dto;

import com.mammadli.to_do_app.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    private String idUser;
    private String title;
    private TaskStatus taskStatus;
    private LocalDateTime deadline;

}
