package com.lzw.compensation.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String buzId;

    private String event;

    private Date time;

}
