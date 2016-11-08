package main.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.modelpojos.User;
import main.modelpojos.User.Role;
import main.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
		
		return "";
    }
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String createAdmin(Model model) {//TEMPORARY METHOD UNTIL WE FIGURE OUT HOW TO CREATE ACCOUNTS ON STARTUP
		User user = new User();
		user.setUsername("Admin");
		user.setPassword("SBUWebAndAppClub");
		user.setRole(Role.ROLE_ADMIN);
		user.setMemberName("Not Applicable");
		userService.createUser(user);
		return "projects";
    }
}
