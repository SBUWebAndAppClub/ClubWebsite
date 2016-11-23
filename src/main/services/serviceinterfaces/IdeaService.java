package main.services.serviceinterfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import main.modelpojos.Idea;

@Service
public interface IdeaService {

	void createIdea(Idea idea);

	void deleteIdea(Idea idea);

	void updateIdea(Idea idea);

	List<Idea> getIdeas();

	Idea getIdeaByID(Integer id);
}
