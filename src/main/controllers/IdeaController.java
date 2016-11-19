package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import main.services.IdeaService;

@Controller
public class IdeaController {
	
	@Autowired
    private IdeaService ideaService;
	
	@RequestMapping(value = "/ideas")
    public String ideaList(Model model) {
        model.addAttribute("ideas", ideaService.getIdeas());
        return "/ideas";
    }
	
	@RequestMapping(value = "/idea/{id}")
    public String idea(@PathVariable Integer id, Model model) {
        model.addAttribute("member", ideaService.getIdeaByID(id));
        return "/idea";
    }
}
