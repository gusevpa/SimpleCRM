package com.example.users;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import org.springframework.http.*;
import org.springframework.web.client.*;

public class TestUserSender {

    public void sendToUserSave(){

        String createPersonUrl = "http://localhost:8095/crm/api/v1/users/createUser";
        String updatePersonUrl = "http://localhost:8095/crm/api/v1/users/updateUser";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode()
                .put("name", "Petya")
                .put("phone", "8 8118118181")
                .put("email", "petya@mail.ru");

        HttpEntity<String> request =
                new HttpEntity<>(objectNode.toString(), headers);

        System.out.println("UPDATE  " + restTemplate.postForObject(updatePersonUrl, request, String.class));
        System.out.println("CREATE  " + restTemplate.postForObject(createPersonUrl, request, String.class));
    }
}

