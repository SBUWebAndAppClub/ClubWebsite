package main.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.modelpojos.Idea;
import main.services.serviceinterfaces.IdeaService;

@Controller
public class IdeaController {

	@Autowired
	private IdeaService ideaService;

	@RequestMapping(value = "/ideas")
	public String ideaList(Model model) {
		model.addAttribute("ideas", ideaService.getIdeas());
		return "ideas";
	}

	@RequestMapping(value = "ideas/new", method = RequestMethod.GET)
	public String newIdea(Model model) {
		Idea idea = new Idea();
		idea.setEmail("@stonybrook.edu");
		model.addAttribute("idea", idea);
		return "form";
	}

	// TODO Send email to stonybrook email to check its validity.
	@RequestMapping(value = "ideas/new", method = RequestMethod.POST)
	public String postIdea(@ModelAttribute @Valid Idea idea, BindingResult bindingResult) {
		//Trim strings
		idea.setName(idea.getName().trim());
		idea.setDescription(idea.getDescription().trim());
		idea.setEmail(idea.getEmail().trim());
		//Check for errors
		if (bindingResult.hasErrors()) {
			return "form";
		}
		ideaService.createIdea(idea);
		return "redirect:/idea/" + idea.getId();
	}

	@RequestMapping(value = "/idea/{id}")
	public String idea(@PathVariable Integer id, Model model) {
		Idea idea = ideaService.getIdeaByID(id);
		if(idea == null){//If idea doesn't exist.
			return "error/404";
		}
		model.addAttribute("idea", idea);
		return "idea";
	}
}
