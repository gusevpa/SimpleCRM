package com.example.users;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import org.apache.http.client.methods.*;
import org.apache.http.entity.*;
import org.apache.http.impl.client.*;
import org.springframework.http.*;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class TestUserSender {

    public ResponseEntity sendToUserSave(String name, String phone, String email){

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8095/crm/api/v1/users/setUser");

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode()
                .put("name", name)
                .put("phone", phone)
                .put("email", email);


        String encodedUser = Base64.getEncoder().encodeToString(objectNode.toString().getBytes(StandardCharsets.UTF_8));
        try{
            post.setEntity(new StringEntity(encodedUser));
            CloseableHttpResponse response = client.execute(post);
            response.close();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
