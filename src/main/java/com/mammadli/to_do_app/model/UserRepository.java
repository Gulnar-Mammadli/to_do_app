package com.mammadli.to_do_app.model;

import com.mammadli.to_do_app.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    User findByIdUser(String idUser);
    User findByUsername(String username);
}
