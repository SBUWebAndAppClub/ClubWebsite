package main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import main.modelpojos.User;

@Service
public interface UserService {
	
	void createUser(User user);

	void deleteUser(User user);

	User getUserByName(String name);

	List<User> getUsers();
}
