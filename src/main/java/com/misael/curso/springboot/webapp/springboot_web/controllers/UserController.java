package com.misael.curso.springboot.webapp.springboot_web.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
        model.addAttribute("title","Listado de Usuarios");
        return "list";
    }

    /*
     * El atributo 'users' ahora es global
     */
    @ModelAttribute("users")
    public List<User> list()
    {
        return Arrays.asList(
            new User("David","Sandoval"), 
            new User("Maryori", "Salazar", "mayo@correo.com"), 
            new User("Mynor", "Gutierrez", "mynor@correo.com"),
            new User("Alejandro", "Salazar"));
    }

}
