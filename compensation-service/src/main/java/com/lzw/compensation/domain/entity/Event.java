package com.lzw.compensation.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String buzId;

    private String event;

    private Date time;

}
