package com.horse.identifier.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long employeeId;
    private String employeeName;
    private String password;
    private Long deptId;
    private Integer sex;
    private Date birthDate;
    private String telNo;
    private String email;
    private String remark;
    private Long createUserId;
    private Date createDate;
    private Long lastModifyUserId;
    private Date lastModifyDate;
    private Long companyId;
    private Long employeeStatusId;
    private String employeeNo;
    private String source;
}