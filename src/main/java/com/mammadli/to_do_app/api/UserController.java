package com.mammadli.to_do_app.api;

import com.mammadli.to_do_app.model.dto.RegistrationRequest;
import com.mammadli.to_do_app.model.dto.UpdateRequest;
import com.mammadli.to_do_app.model.entity.User;
import com.mammadli.to_do_app.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("http://localhost:8081")
public class UserController {

    private final UserServices userServices;

    @PostMapping("/register")
    User registerUser(@RequestBody RegistrationRequest registrationRequest) {
        return userServices.registerUser(registrationRequest);
    }

    @PostMapping("/create")
    User createUser(@RequestBody RegistrationRequest request) {
        return userServices.createUser(request);
    }

    @PutMapping("/update/{id}")
    User updateUser(@RequestBody UpdateRequest request, @PathVariable String id) {
        return userServices.updateUser(request, id);
    }

    @GetMapping("/get/{idUser}")
    User getUser(@PathVariable String idUser) {
        return userServices.getUser(idUser);
    }

    @DeleteMapping("/delete/{idUser}")
    Void deleteUser(@PathVariable String idUser) {
        return userServices.deleteUser(idUser);
    }

}
