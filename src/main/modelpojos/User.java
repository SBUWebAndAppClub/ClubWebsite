package main.modelpojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	
	@Id
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String memberName;//Should be exactly the same as their member object to connect the two!
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;
	
	public enum Role{
		ROLE_USER, ROLE_ADMIN
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getMemberName() {
		return memberName;
	}

	public Role getRole() {
		return role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
