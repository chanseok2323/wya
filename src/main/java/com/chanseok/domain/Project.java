package com.chanseok.domain;

import javax.persistence.*;

@Entity
@Table(name = "wya_project")
public class Project extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private Long no;

    private String projectNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_company_no")
    private CategoryCompany categoryCompany;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;
}
