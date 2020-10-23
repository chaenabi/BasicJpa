package com.app.charlie.repository;

import com.app.charlie.entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() throws Exception {
        // provided resource
        Member member = new Member();
        member.setUsername("memberA");

        // when if 
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        // validate it.
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    }

    @Test
    public void testMember2() throws Exception {
        // provided resource
        Member member = new Member();
        // when if
        member = memberRepository.jpaMain(member);
        Member findMember = memberRepository.find(1L);
 //     System.out.println("findMember = " + findMember.getUsername() + ", age = " + findMember.getAge());
        //       List<Member> members = memberRepository.findMembers();
//      System.out.println("members.size() = " + members.size());

        // validate it.
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    }
}