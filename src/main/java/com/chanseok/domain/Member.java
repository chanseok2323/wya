package com.chanseok.domain;

import lombok.Getter;

import javax.persistence.*;

/**
 * 회원
 */
@Entity
@Getter
@Table(name = "wya_member")
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long no;
    private String email;
    private String password;
    private String nickname;
    private String phone;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public Member() {
    }

    public Member(String email, String password, String nickname, String phone, RoleType roleType) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.roleType = roleType;
    }
}
