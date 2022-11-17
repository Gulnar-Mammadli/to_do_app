package com.mammadli.to_do_app.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
            name = "uuid2",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column( nullable = false,columnDefinition = "VARCHAR(255)")
    private String idUser;

    @Column( nullable = false,columnDefinition = "VARCHAR(255)")
    private String userName;

    @Size(min=6)
    private String password;

    @Column(columnDefinition= "BOOLEAN")
    private boolean deleted = false;

    @OneToMany
    private List<Task> taskList;
}
