package com.example.users.controller;

import com.example.users.entity.*;
import com.example.users.service.*;
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

    /**
     * @param - {'id': 1} - UserEntity, содержащий id пользователя, которого мы хотим вернуть из базы.
     * @return - в случае успеха возвращает UserEntity со всеми полями
     */
    @GetMapping(value = "/users/getuser")
    public ResponseEntity<UserEntity> getById(@RequestBody UserEntity userEntity) {

        try {
            return new ResponseEntity<>(userDataService.getById(userEntity).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param - Внесение пользователя (поле id не вносить) - {'name': 'Olesya', 'phone': '119', 'email': '2olgdsfgso@mail.ru'}
     * Поле email - уникальное. При наличии пользователя с таким же email - пользователь не создастся
     * @return - в случае успеха возвращает {'id': 1} где "1" - айди нового юзера
     *
     * @param - Изменение пользователя (поле id - обязательно) - {'id':1,'name': 'Olesya', 'phone': '119', 'email': '2olgdsfgso@mail.ru'}
     * @return - в случае успеха возвращает {'id': 1} где "1" - айди измененного пользователя
     */
    @PostMapping(
            value = "/users/updateuser",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<String> updateUser(@RequestBody UserEntity userEntity) {
        try {
            return new ResponseEntity<>(userDataService.saveUpdateUser(userEntity), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param userStatus  - {'id': 1, 'status': 'Offline'}, поле status - содержит новый статус
     * @return - {"id":1,"status":"Offline","prevStatus":"Offline"} новый статус и предыдущий
     */
    @PostMapping(
            value = "/users/userstatus",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<UserStatusDto> updateUserStatus(@RequestBody UserStatusDto userStatus) {
        try {
            return new ResponseEntity<>(userStatusService.updateUserStatus(userStatus).get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
