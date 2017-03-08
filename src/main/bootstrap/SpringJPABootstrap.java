package main.bootstrap;

import java.util.HashSet;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import main.modelpojos.Member;
import main.modelpojos.Project;
import main.services.jpaservices.RelationManager;
import main.services.serviceinterfaces.MemberService;
import main.services.serviceinterfaces.ProjectService;

/**
 * Created by Armando on 11/21/2016.
 */
@Component
public class SpringJPABootstrap  implements ApplicationListener<ContextRefreshedEvent> {
	
    private ProjectService projectService;

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
    	
        //Default image path: http://i.imgur.com/QUOGtiN.png
        //Urls array order {Facebook, Google Plus, Github}
        //Replace ' ' in a URL with '%20'
        //Format for URLS: "URL NameToBeShown"
            //Example: "github.com Github"
        //nulls in setUrls causes individual member pages to break  <---------------FIX THIS in member.html

        Member m1 = new Member();
        m1.setId(r.nextInt());
        m1.setFullName("Armando Xhimanki");
        m1.setEmail("armando.xhimanki@stonybrook.edu");
        m1.setMajor("Computer Science");
        m1.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m1.setUrls(null);
        m1.setBio("President");
        m1.setProjects(new HashSet<Project>());

        Member m2 = new Member();
        m2.setId(r.nextInt());
        m2.setFullName("Mikey Gulati");
        m2.setEmail("mankirat.gulati@stonybrook.edu");
        m2.setMajor("Computer Science");
        m2.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m2.setUrls(new String[]{null, null, "https://github.com/devhid Github"});
        m2.setBio("Vice President");
        m2.setProjects(new HashSet<Project>());

        Member m3 = new Member();
        m3.setId(r.nextInt());
        m3.setFullName("Stanley Lim");
        m3.setEmail("stanley.lim@stonybrook.edu");
        m3.setMajor("Computer Science");
        m3.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m3.setUrls(new String[]{null, null, "https://github.com/Spiderpig86 Github"});
        m3.setBio("Treasurer");
        m3.setProjects(new HashSet<Project>());

        Member m4 = new Member();
        m4.setId(r.nextInt());
        m4.setFullName("Daniel Eliasinski");
        m4.setEmail("daniel.eliasinski@stonybrook.edu");
        m4.setMajor("Computer Science");
        m4.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m4.setUrls(new String[]{null, null, "https://github.com/Mr-Slurpy Github"});
        m4.setBio("Lowly Peasant");
        m4.setProjects(new HashSet<Project>());

        Member m5 = new Member();
        m5.setId(r.nextInt());
        m5.setFullName("Ravjot Sachdev");
        m5.setEmail("ravjot.sachdev@stonybrook.edu");
        m5.setMajor("Computer Science");
        m5.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m5.setUrls(new String[]{null, null, "https://github.com/rsachdev19 Github"});
        m5.setBio("Lowly Peasant");
        m5.setProjects(new HashSet<Project>());

        Member m6 = new Member();
        m6.setId(r.nextInt());
        m6.setFullName("Eduardo Quispe");
        m6.setEmail("eduardo.quispe@stonybrook.edu");
        m6.setMajor("Computer Science");
        m6.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m6.setUrls(new String[]{null, null, "https://github.com/edqu3 Github"});
        m6.setBio("Lowly Peasant");
        m6.setProjects(new HashSet<Project>());

        Member m7 = new Member();
        m7.setId(r.nextInt());
        m7.setFullName("Murshid Azher");
        m7.setEmail("mohamedmurshid.mohamedazher@stonybrook.edu");
        m7.setMajor("Computer Science");
        m7.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m7.setUrls(new String[]{null, null, "https://github.com/murshidazher Github"});
        m7.setBio("Lowly Peasant");
        m7.setProjects(new HashSet<Project>());

        Member m8 = new Member();
        m8.setId(r.nextInt());
        m8.setFullName("Steven Chou");
        m8.setEmail("yu-hsiang.chou@stonybrook.edu");
        m8.setMajor("Computer Science");
        m8.setImagePath("http://i.imgur.com/QUOGtiN.png");
        m8.setUrls(new String[]{null, null, "https://github.com/StevenChou888 Github"});
        m8.setBio("Lowly Peasant");
        m8.setProjects(new HashSet<Project>());


        Project p1 = new Project();
        p1.setId(r.nextInt());
        p1.setName("Club Website");
        p1.setDescription("It's a website.");
        p1.setImagePath("http://placehold.it/750x650");
        p1.setWorkingMembers(new HashSet<Member>());

        memberService.createMember(m1);
        memberService.createMember(m2);
        memberService.createMember(m3);
        memberService.createMember(m4);
        memberService.createMember(m5);
        memberService.createMember(m6);
        memberService.createMember(m7);
        memberService.createMember(m8);
        projectService.createProject(p1);


        relationManager.createMemberToProjectRelation(m1.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m2.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m3.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m4.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m5.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m6.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m7.getId(), p1.getId());
        relationManager.createMemberToProjectRelation(m8.getId(), p1.getId());
}
}

