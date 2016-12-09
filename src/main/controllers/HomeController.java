package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.modelpojos.Member;
import main.services.serviceinterfaces.MemberService;

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        List<Member> members = memberService.getMembers();
        model.addAttribute("member1", members.get(0));
        model.addAttribute("member2", members.get(1));
        model.addAttribute("member3", members.get(2));
        return "index";
    }
}
