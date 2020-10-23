package com.app.charlie.repository;

import com.app.charlie.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findMembers() {
      return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Transactional
    public Member jpaMain(Member member) {
        member.setUsername("MemberA");
        member.setAge(20);
        em.persist(member);
        return member;
//		em.remove(member);
    }


}
