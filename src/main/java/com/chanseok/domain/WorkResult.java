package com.chanseok.domain;

import javax.persistence.*;

@Entity
@Table(name = "wya_work_result")
public class WorkResult extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_result_no")
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_no")
    private Work work;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_no")
    private Project project;

    @Enumerated(EnumType.STRING)
    private WorkStatus workStatus;
}
