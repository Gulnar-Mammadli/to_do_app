package com.mammadli.to_do_app.api;

import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.services.UserServices;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServices userServices;

    @PostMapping("/create")
    ResponseEntity<ResponseData<User>> createUser(@RequestBody User user){
        return ResponseEntity.ok(userServices.createUser(user));
    }

    @PutMapping("/update")
    ResponseEntity<ResponseData<User>> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userServices.updateUser(user));
    }

    @GetMapping("/get/{idUser}")
    ResponseEntity<ResponseData<User>> getUser(@PathVariable String idUser){
        return ResponseEntity.ok(userServices.getUser(idUser));
    }

    @DeleteMapping("/delete/{idUser}")
    ResponseEntity<ResponseData<String>> deleteUser(@PathVariable String idUser){
       return ResponseEntity.ok(userServices.deleteUser(idUser));
    }

}
