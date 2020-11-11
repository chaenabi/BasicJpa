package com.app.charlie.repository;

import com.app.charlie.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepository implements CrudRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void insert(Member member) {
        em.persist(member);
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(Long memberId) {

    }

    @Override
    public Optional<Member> select(Long memberId) {
        Optional<Member> nonExist = Optional.empty();
        Member member = em.find(Member.class, memberId);
        return member == null ? nonExist : Optional.of(member);
    }

    @Override
    public List<Member> selectAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
