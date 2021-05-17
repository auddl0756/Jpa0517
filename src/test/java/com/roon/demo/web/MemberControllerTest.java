package com.roon.demo.web;

import com.roon.demo.domain.Member;
import com.roon.demo.service.MemberService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberControllerTest {
    @Autowired
    MemberService memberService;

    @Before
    public void 테스트샘플_저장(){
        memberService.save(
                Member.builder()
                        .name("kim")
                        .city("busan")
                        .street("??")
                        .zipcode("1234")
                        .build()
        );

        memberService.save(
                Member.builder()
                        .name("lee")
                        .city("seoul")
                        .street("worldcup")
                        .zipcode("1234")
                        .build()
        );
    }

    //테스트가  DB에 실제로 영향을 주지 않도록 하기 위해
    @After
    public void clean(){
        memberService.removeAll();
    }

    @Test
    public void 불러오기() {


        Member member = memberService.getAllMembers().get(0);

        System.out.println(member.getName());

        assertThat(member.getName()).isEqualTo("kim");
        assertThat(member.getCity()).isEqualTo("busan");

    }

    @Test
    public void 멤버리스트_출력() {
        List<Member> members = memberService.getAllMembers();
        members.stream()
                .map(x->x.getName())
                .forEach(System.out::println);
    }

    @Test
    public void 쿼리메서드_nameAndcity(){
        List<Member> members = memberService.getByNameAndCity("kim","busan");

        System.out.println(members.get(0).getName());
        assertThat(members.get(0).getName()).isEqualTo("kim");
    }

    @Test
    public void 쿼리어노테이션(){
        List<Member> members = memberService.getByName_쿼리어노테이션("kim");

        System.out.println(members.get(0).getName());
        assertThat(members.get(0).getName()).isEqualTo("kim");
    }

    @Test
    public void 쿼리어노테이션_네이티브SQL(){
        List<Member> members = memberService.getByName_쿼리어노테이션_네이티브SQL("kim");
        System.out.println(members.get(0).getName());
        assertThat(members.get(0).getName()).isEqualTo("kim");
    }

    @Test
    public void 쿼리어노테이션_이름기반바인딩(){
        List<Member> members = memberService.getByName_쿼리어노테이션_이름기반_바인딩("kim");
        System.out.println(members.get(0).getName());
        assertThat(members.get(0).getName()).isEqualTo("kim");
    }

}