package com.github.springprimefaces.controller;

import com.github.springprimefaces.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * @author elvis
 * @version $Revision: $<br/>
 * $Id: $
 * @since 8/11/16 6:05 PM
 */
@ManagedBean(name = "helloBean")
@Scope("request")
@Controller("helloBean")
public class HelloController implements Serializable {

	private String message = "hi";
	@Autowired
	private HelloService helloService;

	@PostConstruct
	public void init() {
		System.out.println("hi");
	}

	public String getHelloWorldMessage() {
		return helloService.getHelloMessage();
	}

	public String getMessage() {
		return message;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String api() {
		return "hey";
	}
}
