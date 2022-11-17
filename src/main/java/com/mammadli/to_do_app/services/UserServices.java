package com.mammadli.to_do_app.services;

import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.util.ResponseData;

public interface UserServices {
    ResponseData<User> createUser(User user);

    ResponseData<User> getUser(String idUser);

    ResponseData<String> deleteUser(String idUser);

    ResponseData<User> updateUser(User user);
}
