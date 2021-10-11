package com.chanseok.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createDt;

    @Column(updatable = false)
    private Long createNo;

    private LocalDateTime updateDt;

    private Long updateNo;
}
