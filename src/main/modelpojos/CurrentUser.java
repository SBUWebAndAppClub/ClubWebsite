package main.modelpojos;

import org.springframework.security.core.authority.AuthorityUtils;

import main.modelpojos.User.Role;

/**
 * Is used when you want to get the current user accessing the website.
 * 
 * @author Daniel Eliasinski
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -272220543357434832L;
	private User user;

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

	public User getUser() {//These methods could be dangerous... Might just end up saving name and having to fetch it again from userservice.
		return user;
	}

	public String getName() {
		return user.getUsername();
	}

	public Role getRole() {
		return user.getRole();
	}
}