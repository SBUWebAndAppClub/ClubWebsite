package main.services.jpaservices;

import main.services.serviceinterfaces.MemberService;
import main.services.serviceinterfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.modelpojos.Member;
import main.modelpojos.Project;

@Component
public class RelationManager {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProjectService projectService;
	
	public void createMemberToProjectRelation(int member, int project){
		//Get entities from database.
		Member m = memberService.getMemberById(member);
		if(m == null)throw new IllegalArgumentException("Could not find project with that name!");
		Project p = projectService.getProjectById(project);
		if(p == null)throw new IllegalArgumentException("Could not find member with that id!");
		//Add entities to each other.
		m.getProjects().add(p);
		p.getWorkingMembers().add(m);
		//Persist changes.
		memberService.updateMember(m);
		projectService.updateProject(p);
	}
}
