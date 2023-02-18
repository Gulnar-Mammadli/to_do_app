package com.mammadli.to_do_app.services.impl;

import com.mammadli.to_do_app.enums.Role;
import com.mammadli.to_do_app.mapper.UserMapper;
import com.mammadli.to_do_app.model.UserRepository;
import com.mammadli.to_do_app.model.dto.RegistrationRequest;
import com.mammadli.to_do_app.model.dto.UpdateRequest;
import com.mammadli.to_do_app.model.entity.User;
import com.mammadli.to_do_app.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;

    @Override
    public User registerUser(RegistrationRequest request) {

        User user = UserMapper.INSTANCE.mapToUser(request);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.ADMIN);
        return userRepository.save(user);
    }

    @Override
    public User createUser(RegistrationRequest request) {
        User response = userRepository.findByUsername(request.getUsername());
        if (response != null) {
            request.setRole(Role.USER);
            request.setPassword(request.getPassword());
            return userRepository.save(UserMapper.INSTANCE.mapToUser(request));
        }
        return null;
    }

    @Override
    public User updateUser(UpdateRequest request, String id) {
        User response = userRepository.findByIdUser(id);
        if (response != null) {
            User user = UserMapper.INSTANCE.fromUpdateRequest(request);
            user.setIdUser(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User getUser(String idUser) {
        return userRepository.findByIdUser(idUser);
    }

    @Override
    public Void deleteUser(String idUser) {
        User user = userRepository.findByIdUserAndDeletedIsFalse(idUser);
        if (user != null) {
            userRepository.deleteById(idUser);
            userRepository.save(user);
        }
        return null;
    }

}
