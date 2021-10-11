package com.chanseok.domain;

import javax.persistence.*;

@Entity
@Table(name = "wya_work")
public class Work extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_no")
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_no")
    private Project project;


}
