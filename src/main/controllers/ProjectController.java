package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.services.serviceinterfaces.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	/**
	 * Creates the project list page.
	 * 
	 * @param model
	 * @return Name of the template.
	 */
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String projectList(Model model) {
		model.addAttribute("projects", projectService.getProjects());
		return "projects";
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public String project(@PathVariable int id, Model model) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "project";
	}

	/*@RequestMapping(value = "/projects/create", method = RequestMethod.GET)
	public String createProjectPage(Model model) {
		Project project = new Project();
		project.setName("Project Name");
		project.setDescription("Add Description...");
		project.setImagePath("Default_Image_Path.png");
		model.addAttribute("project", project);
		return "project_create";
	}

	@RequestMapping(value = "/projects/create", method = RequestMethod.POST)
	public String createProject(@ModelAttribute @Valid Project project, BindingResult bindingResult) {
		//Trim Strings
		project.setName(project.getName().trim());
		project.setDescription(project.getDescription().trim());
		project.(prosetImagePathject.getImagePath().trim());
		// Check if name is taken
		if (projectService.getProjectByName(project.getName()) != null)
			bindingResult.rejectValue("name", "error.name", "Name is taken!");
		// Check for errors
		if (bindingResult.hasErrors()) {
			return "project_create";
		}
		if (project.getImagePath().isEmpty()) {
			project.setImagePath("Default_Image_Path.png");
		}
		if (project.getDescription().isEmpty() || project.getDescription().equals("Add Description...")) {
			project.setDescription("No Description...");
		}
		// Send to the database.
		projectService.createProject(project);
		return "redirect:/projects/" + project.getName();
	}*/
}
