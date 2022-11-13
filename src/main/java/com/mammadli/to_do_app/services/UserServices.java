package com.mammadli.to_do_app.services;

import com.mammadli.to_do_app.db.entity.User;

public interface UserServices {
    User createUser(User user);

    User getUser(String idUser);
}
