package com.lzw.compensation.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_platform")
public class Platform {

    @Id
    @GeneratedValue
    private Long id;

    private String buzId;

    private String service;

    private Integer seq;

    private String status;

    private Date updateTime;

    private String tbName;
}
