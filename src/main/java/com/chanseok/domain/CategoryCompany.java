package com.chanseok.domain;

import javax.persistence.*;

@Entity
@Table(name = "wya_category_company")
public class CategoryCompany extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_company_no")
    private Long no;

    private String categoryCompanyNm;

}
