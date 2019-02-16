package com.github.springprimefaces;

import com.github.springprimefaces.configuration.ViewScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;
import java.util.HashMap;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public static CustomScopeConfigurer customScopeConfigurer() {

		final var scopes = new HashMap<String, Object>();
		scopes.put("view", new ViewScope());

		final CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.setScopes(scopes);
		return configurer;
	}

	@Bean
	public ServletRegistrationBean facesServletRegistraiton() {
		final var registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
		registration.setName("Faces Servlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
			servletContext.setInitParameter("primefaces.THEME", "bootstrap");
			servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
			servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
			servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
			servletContext.setInitParameter("primefaces.UPLOADER", "commons");
		};
	}
}
