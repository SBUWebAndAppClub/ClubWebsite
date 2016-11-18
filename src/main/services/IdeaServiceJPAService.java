package main.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import main.modelpojos.Idea;

public class IdeaServiceJPAService implements IdeaService {
	
	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void createIdea(Idea idea) {
		EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(idea);
    	em.getTransaction().commit();
	}

	@Override
	public void deleteIdea(Idea idea) {
		
	}

	@Override
	public void updateIdea(Idea idea) {
		EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.merge(idea);
    	em.getTransaction().commit();
	}

	@Override
	public List<Idea> getIdeas() {
		return emf.createEntityManager().createQuery("from Idea", Idea.class).getResultList();
	}

	@Override
	public Idea getIdeaByID(Integer id) {
		return null;
	}
}
