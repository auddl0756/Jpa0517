package com.roon.demo.service;

import com.roon.demo.domain.Member;
import com.roon.demo.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public void save(Member member){
        memberRepository.save(member);
    }

    public void removeAll(){
        memberRepository.deleteAll();
    }

    public List<Member> getByNameAndCity(String name,String city){
        return memberRepository.findByNameAndCity(name,city);
    }

    public List<Member> getByNameOrCity(String name,String city){
        return memberRepository.findByNameOrCity(name,city);
    }

    public List<Member> getByName_쿼리어노테이션(String name){
        return memberRepository.findByName(name);
    }

    public List<Member> getByName_쿼리어노테이션_네이티브SQL(String name){
        return memberRepository.findByName2(name);
    }

    public List<Member> getByName_쿼리어노테이션_이름기반_바인딩(String name){
        return memberRepository.findByName_nameBased(name);
    }


}
