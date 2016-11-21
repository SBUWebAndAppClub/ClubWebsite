package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class Application  {
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return (container -> {
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,
					"/projects");
			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/projects");
			container.addErrorPages(error404Page,error500Page);
			
		});

	}


}
