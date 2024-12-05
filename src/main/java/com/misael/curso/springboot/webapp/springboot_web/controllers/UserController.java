package com.misael.curso.springboot.webapp.springboot_web.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.misael.curso.springboot.webapp.springboot_web.models.User;

/*
 Controlador de MVC con thymeleaf
 */
@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model)
    {
        User user = new User("Misael", "Sandoval");
        model.addAttribute("title", "Hola Mundo desde Spring Boot");
        model.addAttribute("user", user);
        
        return "details";
    }
    
    @GetMapping("/list")
    public String list(ModelMap model)
    {
        List<User> users = Arrays.asList(
            new User("David","Sandoval"), 
            new User("Maryori", "Salazar", "mayo@correo.com"), 
            new User("Mynor", "Gutierrez", "mynor@correo.com"),
            new User("Alejandro", "Salazar"));

        model.addAttribute("users", users);
        model.addAttribute("title","Listado de Usuarios");
        return "list";
    }

}
