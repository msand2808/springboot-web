package com.misael.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misael.curso.springboot.webapp.springboot_web.models.dto.ParamUno;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

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
    
}
