package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends RuntimeException {
	
	@RequestMapping(value = "/")
    public String home() {
		
        return "index";
    }


}
