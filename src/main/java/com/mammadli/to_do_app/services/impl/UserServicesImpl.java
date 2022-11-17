package com.mammadli.to_do_app.services.impl;

import com.mammadli.to_do_app.db.UserRepository;
import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.services.UserServices;
import com.mammadli.to_do_app.util.GenerateResponseUtility;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

    public static int SUCCESS_CODE = 200;
    public static int ALREADY_EXIST_CODE = 409;
    public static int NOT_FOUND_CODE = 404;
    public static String SUCCESS_MESSAGE = "SUCCESS";
    public static String NOT_FOUND_MESSAGE = "NOT_FOUND";
    public static String ALREADY_EXIST_MESSAGE = "ALREADY EXIST";

    private final UserRepository userRepository;

    @Override
    public ResponseData<User> createUser(User user) {
        User response = userRepository.findByIdUser(user.getIdUser());
        if(response==null){
            User newUser = userRepository.save(user);
            return GenerateResponseUtility.userFunc.generate(SUCCESS_CODE,SUCCESS_MESSAGE,newUser);

        }
        return GenerateResponseUtility.userFunc.generate(ALREADY_EXIST_CODE,ALREADY_EXIST_MESSAGE,null);
    }

    @Override
    public ResponseData<User> updateUser(User user) {
        User response = userRepository.findByIdUserAndDeletedIsFalse(user.getIdUser());
        if(response!=null){
            User updated = userRepository.save(user);
            return GenerateResponseUtility.userFunc.generate(SUCCESS_CODE,SUCCESS_MESSAGE,updated);
        }
        return GenerateResponseUtility.userFunc.generate(NOT_FOUND_CODE,NOT_FOUND_MESSAGE,null);
    }

    @Override
    public ResponseData<User> getUser(String idUser) {
        User user = userRepository.findByIdUserAndDeletedIsFalse(idUser);
        if(user!=null){
            return GenerateResponseUtility.userFunc.generate(SUCCESS_CODE,SUCCESS_MESSAGE,user);
        }
        return GenerateResponseUtility.userFunc.generate(NOT_FOUND_CODE,NOT_FOUND_MESSAGE,null);
    }

    @Override
    public ResponseData<String> deleteUser(String idUser) {
        User user = userRepository.findByIdUserAndDeletedIsFalse(idUser);
        if(user != null){
            user.setDeleted(true);
            User save = userRepository.save(user);
            return GenerateResponseUtility.func.generate(SUCCESS_CODE,SUCCESS_MESSAGE,null );
        }
        return GenerateResponseUtility.func.generate(NOT_FOUND_CODE,NOT_FOUND_MESSAGE,null);
    }

}
