package com.chanseok.domain;

import javax.persistence.*;

/**
 * 일반회원 <-> 능력자 연결 성사 시 매칭 테이블
 */
@Entity
@Table(name = "wya_match")
public class Match extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_no")
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_no")
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;
}
