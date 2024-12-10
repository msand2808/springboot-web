package com.misael.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/*
 * Configurando las propiedades personalizadas de el proyecto, con @PropertySources se pueden configurar mas
 */
@PropertySource("classpath:values.properties")
public class ValuesConfig {

}
