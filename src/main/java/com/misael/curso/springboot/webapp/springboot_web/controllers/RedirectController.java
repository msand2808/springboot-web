package com.misael.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RedirectController {

    @GetMapping({"","/","/home"})
    public String home() {
        return "redirect:/list";
    }
    

}
