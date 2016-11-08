package main.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import main.modelpojos.User;

@Service
public class UserServiceJPAImpl implements UserService{
	
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List<User> getUsers() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from User", User.class).getResultList();
	}
	
    public User getUserByName(String name) {
    	EntityManager em = emf.createEntityManager();
        return em.find(User.class, name);
    }
    
    public void createUser(User user){
    	EntityManager em = emf.createEntityManager();
    	//Encode password.
    	user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));//Apparently this hasher is better then the industry standard O.o
    	em.getTransaction().begin();
    	em.persist(user);
    	em.getTransaction().commit();
    }

	@Override
	public void deleteUser(User user) {
		
	}
}
