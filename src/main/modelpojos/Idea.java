package main.modelpojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;

@Entity
public class Idea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;
	
	@Pattern(message = "Can'''t be empty!", regexp = ".*[^ ].*")
	public String name;
	
	@Pattern(message = "Can'''t be empty!", regexp = ".*[^ ].*")
	public String description;
	
	//Makes sure the email is a valid Stonybrook email. Doesn't send them an email to check, however.(yet!)
	@Pattern(message = "Not a stonybrook email!", regexp = "\\S+@stonybrook\\.edu$")
	public String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
