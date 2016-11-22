package main.controllers;

import main.modelpojos.Idea;
import main.services.serviceinterfaces.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IdeaController {
	
	@Autowired
    private IdeaService ideaService;
	
	@RequestMapping(value = "/ideas")
    public String ideaList(Model model) {
        model.addAttribute("ideas", ideaService.getIdeas());
        return "ideas";
    }

    @RequestMapping(value="ideas/new", method = RequestMethod.GET)
    public String newIdea(Model model){
        model.addAttribute("idea", new Idea());
        return "idea_create";
    }
    //TODO sbu email verification
    @RequestMapping(value = "ideas/new", method = RequestMethod.POST)
    public String postIdea(@ModelAttribute @Valid Idea idea, BindingResult bindingResult){
    ideaService.createIdea(idea);
    return "redirect:/ideas";
    }




	@RequestMapping(value = "/idea/{id}")
    public String idea(@PathVariable Integer id, Model model) {
        model.addAttribute("idea", ideaService.getIdeaByID(id));
        return "/idea";
    }
}
