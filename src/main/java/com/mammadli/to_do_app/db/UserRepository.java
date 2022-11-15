package com.mammadli.to_do_app.db;

import com.mammadli.to_do_app.db.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    User findByIdUser(String idUser);
}
