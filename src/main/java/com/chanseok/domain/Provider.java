package com.chanseok.domain;

import javax.persistence.*;

/**
 * 능력자 테이블
 */
@Entity
@Table(name = "wya_provider")
public class Provider extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_no")
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    private String verification;
    private String location;
}
