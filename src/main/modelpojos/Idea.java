package main.modelpojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Idea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public String name;
	
	public String description, email;
	
}
