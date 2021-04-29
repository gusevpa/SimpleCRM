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
    private final UserStatusService userStatusService;

    public UserController(UserDataService userDataService, UserStatusService userStatusService) {
        this.userDataService = userDataService;
        this.userStatusService = userStatusService;
    }

    @GetMapping(value = "/users/getuser",
            produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
            headers = "Accept=application/json")
    public ResponseEntity<UserEntity> getById(String id) {

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
    public ResponseEntity<String> createUser(UserEntity userEntity) {
        try {
            return new ResponseEntity<>(userDataService.saveUpdateUser(userEntity), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(
            value = "/users/updateuser",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<String> updateUser(UserEntity userEntity) {
        try {
            return new ResponseEntity<>(userDataService.saveUpdateUser(userEntity), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(
            value = "/users/userstatus",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<UserStatusDto> updateUserStatus(UserStatusDto userStatus) {
        try {
            return new ResponseEntity<>(userStatusService.updateUserStatus(userStatus).get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
