package com.horse.identifier.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Evidence {
    private Long evidenceId;
    private String employeeNo;
    private Long createUserId;
    private Date createDate;
    private Long lastModifyUserId;
    private Date lastModifyDate;
    private String globalUniqueNo;
    private Double price;
    private String address;
    private String img1;
    private String img2;
}
