package main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import main.modelpojos.CurrentUser;
import main.modelpojos.User;

@Component
public class CurrentUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserService userService;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        if(user == null)throw new UsernameNotFoundException(String.format("User with Name=%s was not found", username));
        return new CurrentUser(user);
    }
}