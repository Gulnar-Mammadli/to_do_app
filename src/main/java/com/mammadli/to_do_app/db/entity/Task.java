package com.mammadli.to_do_app.db.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mammadli.to_do_app.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Task {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
            name = "uuid2",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column( nullable = false,columnDefinition = "VARCHAR(255)")
    private String id;

    private String idUser;
    private String title;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDateTime deadline;


}
