package com.chanseok.domain;

import javax.persistence.*;

/**
 * 기업 테이블
 */
@Entity
@Table(name = "wya_company")
public class Company extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_no")
    private Long no;

    private String companyNm;

    @Column(name = "bsn_content")
    private String businessContents;
}
