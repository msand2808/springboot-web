package com.misael.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misael.curso.springboot.webapp.springboot_web.models.User;
import com.misael.curso.springboot.webapp.springboot_web.models.dto.ParamUno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    /*
     * Valores dados en la configuracion de la aplicacion
     */
    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.list}")
    private String[] list;

    @Value("${config.code}")
    private Integer code;

    @GetMapping("/baz/{message}")
    public ParamUno baz(@PathVariable String message)
    {
        ParamUno param = new ParamUno();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable(name = "product") String producto, @PathVariable long id) {

        Map<String, Object> json = new HashMap<>();
        json.put("producto", producto);
        json.put("id",id);

        return json;
    }

    /*Crear usuario mediante PostMan (para pruebas) */
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        
        /*
         * Se inserta el usuario enviado a una base de datos
         */

        /*
         * CODIGO DE INSERSION A LA BASE DE DATOS
         */
        
         user.setName(user.getName().toUpperCase());

        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> getValues()
    {
        Map<String,Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("list", list);


        return json;
    }
    
    
}
