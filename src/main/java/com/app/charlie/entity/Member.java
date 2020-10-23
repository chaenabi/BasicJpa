package com.app.charlie.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    @NonNull
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String username;

    @Column(name = "AGE")
    private Integer age;



}
