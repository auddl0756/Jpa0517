package com.roon.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //쿼리 메서드 기능
    List<Member> findByNameAndCity(String name, String city);

    List<Member> findByNameOrCity(String name,String city);

    //@Query 어노테이션 활용
    @Query("select m from Member m where m.name=?1")
    List<Member> findByName(String name);

    //@Query, 이름 기반 바인딩
    @Query("select m from Member m where m.name=:name")
    List<Member> findByName_nameBased(@Param("name") String name);

    //@Query, 네이티브 SQL사용
    @Query(value = "select * from Member where name=?1",nativeQuery = true)
    List<Member> findByName2(String name);
}
