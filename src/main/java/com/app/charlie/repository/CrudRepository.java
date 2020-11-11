package com.app.charlie.repository;

import com.app.charlie.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudRepository {
    void insert(Member member);
    void update(Member member);
    void delete(Long memberId);
    Optional<Member> select(Long memberId);
    List<Member> selectAll();
}
