package com.github.springprimefaces;

import java.util.HashMap;
import java.util.Map;

import javax.faces.webapp.FacesServlet;

import com.github.springprimefaces.configuration.ViewScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lvasek on 17/04/15.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean facesServletRegistraiton() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(), new String[]{"*.xhtml"});
        registration.setName("Faces Servlet");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            //servletContext.setInitParameter("primefaces.THEME", "bootstrap");
            servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
            servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        };
    }

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<String, Object>();
        scopes.put("view", new ViewScope());
        configurer.setScopes(scopes);
        return configurer;
    }
}
