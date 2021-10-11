package com.chanseok.domain;

import javax.persistence.*;

/**
 * 회원
 */
@Entity
@Table(name = "wya_member")
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long no;
    private String email;
    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}
