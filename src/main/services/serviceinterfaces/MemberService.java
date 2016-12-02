package main.services.serviceinterfaces;


import java.util.List;

import main.modelpojos.Member;

public interface MemberService {
	
	void createMember(Member member);
	
	void deleteMember(Member member);
	
	void updateMember(Member member);
	
    List<Member> getMembers();

    Member getMemberById(Integer id);
}
