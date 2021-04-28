package com.example.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);

//			System.out.println(new TestUserSender().sendToUserSave("Petya", "8 8118118181", "petya@mail.ru"));
			System.out.println(new TestUserSender().sendToUserSave("Ivan", "7 7117117171", "ivan@mail.ru"));
	}
}
