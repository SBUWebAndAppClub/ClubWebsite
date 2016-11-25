package main.controllers;

import main.modelpojos.Idea;
import main.services.serviceinterfaces.EmailManager;
import main.services.serviceinterfaces.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.validation.Valid;

@Controller
public class IdeaController {

	@Autowired
	private IdeaService ideaService;

	@Autowired
	private EmailManager emailManager;

	public void setEmailManager(EmailManager emailManager) {
		this.emailManager = emailManager;
	}
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
	
	private static SecureRandom random = new SecureRandom();
	
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
		idea.setVerificationLink(new BigInteger(130, random).toString(32));
		idea.setVerified(false);
		ideaService.createIdea(idea);
		emailManager.verifyEmail(idea);
		return "redirect:/idea/" + idea.getId();
	}

	@RequestMapping(value = "/idea/{id}")
	public String idea(@PathVariable Integer id, Model model) {
		Idea idea = ideaService.getIdeaByID(id);
		if(idea == null || !idea.isVerified()){//If idea doesn't exist or hasn't been verified yet!
			return "error/404";
		}
		model.addAttribute("idea", idea);
		return "idea";
	}
	
	@RequestMapping(value = "/idea/{id}/{verification}")
	public String idea(@PathVariable Integer id, @PathVariable String verification, Model model) {
		Idea idea = ideaService.getIdeaByID(id);
		if(idea == null || !idea.getVerificationLink().equals(verification)){//If idea doesn't exist or verification string doesn't match!
			return "error/404";
		}
		idea.setVerified(true);
		idea.setVerificationLink("DONE");
		ideaService.updateIdea(idea);
		model.addAttribute("idea", idea);
		return "idea";
	}
}
