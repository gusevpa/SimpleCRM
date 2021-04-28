package com.example.users.Controller;

import com.example.users.Entity.UserEntity;
import com.example.users.Service.UserDataService;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import org.apache.http.client.methods.*;
import org.apache.http.entity.*;
import org.apache.http.impl.client.*;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

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

    @PostMapping(path = "/users/setUser")
    @ResponseBody
    public String getData(@RequestBody String string) {
        try {
            String response = userDataService.saveUser(string).toString();
            System.out.println(response);
            return response;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST).toString();
        }
    }
}
