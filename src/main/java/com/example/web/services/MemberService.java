package com.example.web.services;

import com.example.web.entities.Member;
import com.example.web.entities.MemberLogin;
import com.example.web.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public void insertUser(Member member) {
        try {
            memberRepository.save(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Member> getUsers() {
        return memberRepository.findAll();
    }
    public Member getUser(MemberLogin memberLogin) {
        List<Member> members = memberRepository.findAll();
        Member member = new Member();
        for (Member _member : members) {
            if(_member.getPassword().equals(memberLogin.getPassword()) && _member.getLogin().equals(memberLogin.getLogin())) {
                member = _member;
                break;
            }
        }
        return member;
    }

    public Member getUserByName(String name) {
        List<Member> members = memberRepository.findAll();
        Member member = new Member();
        for (Member _member : members) {
            if(_member.getLogin().equals(name)) {
                member = _member;
                break;
            }
        }
        return member;
    }

    public Member getUserById(long id) {
        List<Member> members = memberRepository.findAll();
        Member member = new Member();
        for (Member _member : members) {
            if(_member.getId().equals(id)) {
                member = _member;
                break;
            }
        }
        return member;
    }

    public Boolean removeUser(int id) {
        List<Member> memberList = getUsers();
        int sizeBefore = memberList.size();
        memberRepository.delete(getUserById(Long.parseLong(Integer.toString(id))));
        int sizeAfter = getUsers().size();
        if (sizeBefore != sizeAfter) {
            return true;
        }
        return false;
    }

}
