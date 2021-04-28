package com.example.users.Controller;

import com.example.users.Entity.*;
import com.example.users.Service.*;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import javax.servlet.http.*;

@RestController
@RequestMapping("/crm/api/v1")
public class UserController {

    private final UserDataService userDataService;

    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @ResponseBody
    @GetMapping(value = "/users/getById",
            produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
            headers = "Accept=application/json")
    public ResponseEntity<UserEntity> getById(@RequestParam String id) {
        try {
            return new ResponseEntity<>(userDataService.getById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(
            value = "/users/createUser",consumes = "application/json", produces = "application/json")
    public String createUser(@RequestBody UserEntity userEntity) {
        return userDataService.saveUpdateUser(userEntity);
    }

    @PostMapping(
            value = "/users/updateUser",consumes = "application/json", produces = "application/json")
    public String updateUser(@RequestBody UserEntity userEntity, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/findPerson/" + userEntity.getId()).toUriString());
        return userDataService.saveUpdateUser(userEntity);
    }
}
