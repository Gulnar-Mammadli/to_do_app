package com.mammadli.to_do_app.api;

import com.mammadli.to_do_app.db.entity.User;
import com.mammadli.to_do_app.services.UserServices;
import com.mammadli.to_do_app.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServices userServices;

    @PostMapping
    ResponseEntity<ResponseData<User>> createUser(@RequestBody User user){
        return ResponseEntity.ok(userServices.createUser(user));
    }

    @GetMapping("/{idUser}")
    ResponseEntity<ResponseData<User>> getUser(@PathVariable String idUser){
        return ResponseEntity.ok(userServices.getUser(idUser));
    }

    @DeleteMapping("/{idUser}")
    ResponseEntity<ResponseData<String>> deleteUser(@PathVariable String idUser){
       return ResponseEntity.ok(userServices.deleteUser(idUser));
    }

}
