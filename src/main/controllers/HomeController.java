package main.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PropertySource("classpath:httpErrorCodes.properties")
public class HomeController {

	@RequestMapping(value = "/")
	public String home() {

		return "index";
	}

	@RequestMapping(value = "/errors", method = RequestMethod.GET)
	public String renderErrorPage(final Model model, final HttpServletRequest request) {

		// Get the Http error code.
		final int error_code = getHttpStatusCode(request);

		// Generates Error message for corresponding Http Error Code.
		final String error_message = generateErrorMessage(error_code);

		model.addAttribute("errorMsg", error_message);
		return "error";
	}

	private int getHttpStatusCode(final HttpServletRequest request) {
		return (int) request.getAttribute("javax.servlet.error.status_code");
	}

	@Autowired
	private Environment env;

	public String generateErrorMessage(final int error_code) {
		String message = "";
		switch (error_code) {
		case 400:
			message = env.getProperty("400");
			break;
		case 404:
			message = env.getProperty("404");
			break;
		case 500:
			message = env.getProperty("500");
			break;
		// etc
		// Put in all Http error codes here.
		}
		return message;
	}
}
