package com.misael.curso.springboot.webapp.springboot_web.controllers;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misael.curso.springboot.webapp.springboot_web.models.User;
import com.misael.curso.springboot.webapp.springboot_web.models.dto.UserDto;



@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details()
    {
        UserDto userDto = new UserDto();
        userDto.setTitle("Hola Mundo desde Spring Boot");
        User user = new User("Misael", "Sandoval");
        userDto.setUser(user);

        return userDto;
    }


    @GetMapping("/list")
    public List<User> list()
    {
        User user = new User("Misael", "Sandoval");
        User user1 = new User("Naomy", "Cu");
        User user2 = new User("Luciana", "Mazariegos");

        List<User> list = Arrays.asList(user,user1,user2);

        /*
        Alternativa
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
         */
        return list;
    }
    
}
