package main.bootstrap;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import main.modelpojos.Idea;
import main.modelpojos.Member;
import main.modelpojos.Project;
import main.services.jpaservices.IdeaServiceJPAImpl;
import main.services.jpaservices.RelationManager;
import main.services.serviceinterfaces.IdeaService;
import main.services.serviceinterfaces.MemberService;
import main.services.serviceinterfaces.ProjectService;

/**
 * Created by Armando on 11/21/2016.
 */
@Component
public class SpringJPABootstrap  implements ApplicationListener<ContextRefreshedEvent> {
    private ProjectService projectService;
    private IdeaService ideaService;
    

   
    @Autowired
	public void setIdeaService(IdeaService ideaService) {
		this.ideaService = ideaService;
	}

	@Autowired
    public void setRelationManager(RelationManager relationManager) {
        this.relationManager = relationManager;
    }

    private RelationManager relationManager;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    private MemberService memberService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createMemberAndProjectData();
    }

    private void createMemberAndProjectData() {
    	Random r = new Random();
    	
        Member m1 = new Member();
        m1.setId(r.nextInt(Integer.MAX_VALUE));
        m1.setFullName("Daniel Eliasinski");
        m1.setEmail("nope@stonybrook.edu");
        m1.setMajor("Computer Science");
        m1.setImagePath("https://storage.googleapis.com/imgfave/image_cache/1405665241680752.jpg");
        m1.setUrls(new String[]{"/projects/Club%20Website Club project", "https://www.google.com/ Google Website"});
        m1.setBio("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        m1.setProjects(new HashSet<Project>());

        Member m2 = new Member();
        m2.setId(r.nextInt(Integer.MAX_VALUE));
        m2.setFullName("Armando Xhimanki");
        m2.setEmail("sup@stonybrook.edu");
        m2.setMajor("Science");
        m2.setImagePath("https://storage.googleapis.com/imgfave/image_cache/1405665241680752.jpg");
        m2.setUrls(new String[]{"/projects/Club%20Website Club project", "https://www.google.com/ Google Website"});
        m2.setBio("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        m2.setProjects(new HashSet<Project>());

        Member m3 = new Member();
        m3.setId(r.nextInt(Integer.MAX_VALUE));
        m3.setFullName("Donald Trump");
        m3.setEmail("hey@stonybrook.edu");
        m3.setMajor("Computer");
        m3.setImagePath("http://static6.businessinsider.com/image/55918b77ecad04a3465a0a63/nbc-fires-donald-trump-after-he-calls-mexicans-rapists-and-drug-runners.jpg");
        m3.setUrls(new String[]{"/projects/Club%20Website Club project", "https://www.google.com/ Google Website"});
        m3.setBio("“Trump steaks, where are the steaks? Do we have the steaks?” he said. “We have Trump steaks. And by the way, you want to take one, we charge you about, what, 50 bucks a steak? Nah, I won’t.”");
        m3.setProjects(new HashSet<Project>());

        Project p1 = new Project();
        p1.setId(r.nextInt(Integer.MAX_VALUE));
        p1.setName("Club Website");
        p1.setDescription("It's a website.");
        p1.setImagePath("http://placehold.it/750x650");
        p1.setWorkingMembers(new HashSet<Member>());

        memberService.createMember(m1);
        memberService.createMember(m2);
        memberService.createMember(m3);
        projectService.createProject(p1);


        relationManager.createMemberToProjectRelation(m1.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m2.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m3.getId(), p1.getId());

        for(int index = 1; index < 45; index++){
            Project p = new Project();
            p.setId(r.nextInt(Integer.MAX_VALUE));
            p.setName("Test Project " + index);
            p.setDescription("TESTING.");
            p.setImagePath("http://i.imgur.com/WYiyYu1.jpg");
            p.setWorkingMembers(new HashSet<Member>());

            projectService.createProject(p);
            }
//        ideaService = new IdeaServiceJPAImpl();
    	SecureRandom secureRandom = new SecureRandom();
    	Random random = new Random();
        Idea idea = new Idea();
        idea.setDescription("IDEAewrqewr");
        idea.setEmail("armando.xhimanki@stonybrook.edu");
        idea.setVerified(true);
        idea.setName("idea1");
        idea.setId(random.nextInt(Integer.MAX_VALUE));
       
        ideaService.createIdea(idea);
        }
    }

