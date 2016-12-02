package main.services.jpaservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import main.services.serviceinterfaces.ProjectService;
import org.springframework.stereotype.Service;

import main.modelpojos.Project;

@Service
public class ProjectServiceJPAImpl implements ProjectService {
	
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List<Project> getProjects() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Project", Project.class).getResultList();
	}
	
    public Project getProjectById(int id) {
    	EntityManager em = emf.createEntityManager();
        return em.find(Project.class, id);
    }
    
    public void createProject(Project project){
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(project);
    	em.getTransaction().commit();
    }

	@Override
	public void deleteProject(Project project) {
		
	}

	@Override
	public void updateProject(Project project) {
		EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.merge(project);
    	em.getTransaction().commit();
	}
}
