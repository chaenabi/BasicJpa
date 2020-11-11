package com.app.charlie.controller;

import com.app.charlie.entity.Member;
import com.app.charlie.entity.Team;
import com.app.charlie.repository.CrudRepository;
import com.app.charlie.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class ExController {

    @Autowired
    CrudRepository crudRepository;

    @GetMapping("/")
    public String hello() {
        return "hello charlie";
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Member member) {
        Team team = new Team();
        team.setTeamName("Default");
        team.setRegdate(LocalDateTime.now());
        member.setTeam(team);
        crudRepository.insert(member);
        return "inserted";
    }

    @GetMapping("/selectOne/{id}")
    public Optional<Member> select(@PathVariable Long id) {
        return crudRepository.select(id);
    }

}
