package com.mammadli.to_do_app.services;

import com.mammadli.to_do_app.model.dto.RegistrationRequest;
import com.mammadli.to_do_app.model.dto.UpdateRequest;
import com.mammadli.to_do_app.model.entity.User;
import com.mammadli.to_do_app.util.ResponseData;

public interface UserServices {
    User createUser(RegistrationRequest request);

    User updateUser(UpdateRequest request,String id);

    User getUser(String idUser);

    Void deleteUser(String idUser);

    User registerUser(RegistrationRequest request);
}
