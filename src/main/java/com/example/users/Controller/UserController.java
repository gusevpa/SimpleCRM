package com.example.users.Controller;

import com.example.users.Entity.*;
import com.example.users.Service.*;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер. Честно.
 */
@RestController
@RequestMapping("/crm/api/v1")
public class UserController {

    private final UserDataService userDataService;

    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @ResponseBody
    @GetMapping(value = "/users/getbyid",
            produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
            headers = "Accept=application/json")
    public ResponseEntity<UserEntity> getById(@RequestParam(name = "id") String id) {
        try {
            return new ResponseEntity<>(userDataService.getById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(
            value = "/users/createuser",
            consumes = "application/json",
            produces = "application/json")
    public String createUser(@RequestBody UserEntity userEntity) {
        return userDataService.saveUpdateUser(userEntity);
    }

    @PostMapping(
            value = "/users/updateuser",
            consumes = "application/json",
            produces = "application/json")
    public String updateUser(@RequestBody UserEntity userEntity) {
        return userDataService.saveUpdateUser(userEntity);
    }
}
