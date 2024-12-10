package com.misael.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment environment;

    /*
     * NO OLVIDAR COLOCAR EL #
     */
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    /*
     * Spring Expresion Language
     */
    @Value("#{'${config.list}'.toUpperCase().split(',')}")
    private List<String> lista;

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
        json.put("username2", environment.getProperty("config.username"));
        json.put("code", code);
        json.put("code2", environment.getProperty("config.code",Long.class));
        json.put("message", message);
        json.put("list", list);
        json.put("lista", lista);
        json.put("valuesMap", valuesMap);

        return json;
    }
    
    
}
