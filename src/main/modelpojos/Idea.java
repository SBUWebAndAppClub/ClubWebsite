package main.modelpojos;

import javax.persistence.*;

@Entity
public class Idea {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;


	public String name;
	public String description;
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
