package com.mammadli.to_do_app.services.impl;

import com.mammadli.to_do_app.db.UserRepository;
import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String idUser) {
        return userRepository.findUserByIdUser(idUser);
    }

}
