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
    	
        Member m1 = new Member();
        m1.setId(r.nextInt(Integer.MAX_VALUE));
        m1.setFullName("Daniel Eliasinski");
        m1.setEmail("nope@stonybrook.edu");
        m1.setMajor("Computer Science");
        m1.setImagePath("None");
        m1.setUrls(new String[]{"/projects/Club%20Website Club project", "https://www.google.com/ Google Website"});
        m1.setBio("Just a kid tryin' to live");
        m1.setProjects(new HashSet<Project>());

        Member m2 = new Member();
        m2.setId(r.nextInt(Integer.MAX_VALUE));
        m2.setFullName("otehr guy");
        m2.setEmail("sup@stonybrook.edu");
        m2.setMajor("Science");
        m2.setImagePath("None");
        m2.setUrls(new String[]{"/projects/Club%20Website Club project", "https://www.google.com/ Google Website"});
        m2.setProjects(new HashSet<Project>());

        Member m3 = new Member();
        m3.setId(r.nextInt(Integer.MAX_VALUE));
        m3.setFullName("another guy");
        m3.setEmail("hey@stonybrook.edu");
        m3.setMajor("Computer");
        m3.setImagePath("None");
        m3.setUrls(new String[]{"/projects/Club%20Website Club project", "https://www.google.com/ Google Website"});
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
    }
    }

