package ru.darvell.webstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/main")
	public String showMainPageFromMain(){
		return "index";
	}

	@RequestMapping(value = "/")
	public String showMainPage(){
		return "index";
	}
}
