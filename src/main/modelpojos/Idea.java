package main.modelpojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Idea {
	
	@Id
	private Integer id;

	@Version
	private Integer version;
	
	@Pattern(message = "Can'''t be empty!", regexp = ".*[^ ].*")
	@Size(message = "Must be longer than 5 characters!", min = 5)
	private String name;
	
	@Pattern(message = "Can'''t be empty!", regexp = ".*[^ ].*")
	@Size(message = "Must be longer than 30 characters!", min = 30)
	private String description;
	
	@Pattern(message = "Not a stonybrook email!", regexp = "\\S+@stonybrook\\.edu$")
	private String email;
	
	private String[] tags;
	
	private boolean verified;
	
	public String getVerificationLink() {
		return verificationLink;
	}

	public void setVerificationLink(String verificationLink) {
		this.verificationLink = verificationLink;
	}
	
	private String verificationLink;

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

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
		this.email = email.toLowerCase();
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
}
