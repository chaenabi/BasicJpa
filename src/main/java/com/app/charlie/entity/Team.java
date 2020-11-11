package com.app.charlie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@ToString
public class Team {

    @Id @GeneratedValue
    @NonNull
    @Column(name = "team_id")
    private Long id;

    @Column
    private String teamName;

    @Column
    @DateTimeFormat
    private LocalDateTime regdate;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private final List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);

        // 무한 루프에 빠지지 않도록 체크
        if (member.getTeam() != this) {
           member.setTeam(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public List<Member> getMembers() {
        return members;
    }
}
