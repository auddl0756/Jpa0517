package com.roon.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //쿼리 메서드 기능
    List<Member> findByNameAndCity(String name, String city);

    List<Member> findByNameOrCity(String name,String city);

    //@Query 어노테이션 활용
    @Query("select m from Member m where m.name=?1")
    List<Member> findByName(String name);

    @Query(value = "select * from Member where name=?1",nativeQuery = true)
    List<Member> findByName2(String name);
}
