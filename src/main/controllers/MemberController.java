package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import main.modelpojos.Member;
import main.services.serviceinterfaces.MemberService;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/members")
    public String memberList(Model model) {
        model.addAttribute("members", memberService.getMembers());


        return "/members";

    }

    @RequestMapping(value = "/member/{id}")
    public String member(@PathVariable Integer id, Model model) {
    	Member member = memberService.getMemberById(id);
    	if(member == null){
    		model.addAttribute("error", "Bad Request");
    		model.addAttribute("status", "402");
    		model.addAttribute("message", "The request you sent could not be processed! Check to see if the id is correct.");
    		return "error";
    	}
        model.addAttribute("member", member);
        return "member";
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
}
