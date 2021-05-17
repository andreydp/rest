package com.poletaiev.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource("WEB-INF/applicationContext.xml")
@ComponentScan(basePackages = "com.poletaiev")
public class AppConfig  extends WebMvcConfigurerAdapter {

}