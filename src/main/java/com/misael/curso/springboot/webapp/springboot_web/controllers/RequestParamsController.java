package com.misael.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misael.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    /*
     * El parametro es enviado por un signo de pregunta '?', y el nombre del parametro del metodo, a no ser que se haya utilizado un main en el requestparam
     * por ejemplo /foo?message= Hola que tal
     */
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Mensaje predeterminado") String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    /*
     * Para recibir 2 parametros o mas, se hace lo mismo, pero se separan los parametros con &
     */
    @GetMapping("/bar")
    public ParamDto bar(@RequestParam() String text, @RequestParam() Integer code) {
        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(text);
        paramDto.setCode(code);

        return paramDto;
    }
    /*
     * Manejando parametros con httpServletRequest
     */
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        ParamDto params = new ParamDto();
        //valor por defecto de code
        Integer code = 0;

        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (Exception e) {
            
        }

        params.setCode(code);
        params.setMessage(request.getParameter("message"));

        return params;
    }
    
    

}
