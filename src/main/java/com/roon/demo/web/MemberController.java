package com.roon.demo.web;

import com.roon.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roon.demo.service.MemberService;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public List<Member> showAllMembers(){
        List<Member> members = memberService.getAllMembers();
        return  members;
    }
}
