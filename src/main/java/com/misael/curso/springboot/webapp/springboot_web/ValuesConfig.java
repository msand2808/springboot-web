package com.misael.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
/*
 * Configurando las propiedades personalizadas de el proyecto, con @PropertySources se pueden configurar mas
 */
@PropertySources(
    {
        @PropertySource(value="classpath:values.properties", encoding = "UTF-8")
    })

public class ValuesConfig {

}
