DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	employee_id int NOT NULL COMMENT '主键ID',
	employee_name varchar NULL DEFAULT NULL COMMENT '姓名',
	password varchar NULL DEFAULT NULL COMMENT '密码',
	dept_id NUMBER(18) NULL DEFAULT NULL COMMENT '部门ID',
	sex NUMBER(18) NULL DEFAULT NULL COMMENT '性别',
	birth_date DATE NULL DEFAULT NULL COMMENT '出生年月日',
	tel_no varchar NULL DEFAULT NULL COMMENT '联系电话',
	email varchar NULL DEFAULT NULL COMMENT '电子邮件',
	remark varchar NULL DEFAULT NULL COMMENT '备注',
	create_user_id BIGINT NULL COMMENT '创建人ID',
    create_date DATE NULL DEFAULT NULL COMMENT '创建时间',
    last_modify_user_id BIGINT  NULL COMMENT '修改人ID',
    last_modify_date DATE NULL DEFAULT NULL COMMENT '修改时间',
    company_id int  NULL COMMENT '公司ID',
    employee_status_id int  NULL COMMENT '员工状态',
    employee_no varchar NOT NULL COMMENT '员工编码',
    source varchar NOT NULL COMMENT '数据来源',
	PRIMARY KEY (employee_id)
);

CREATE TABLE evidence
(
	evidence_id int NOT NULL COMMENT '主键ID',
	employee_no varchar NOT NULL COMMENT '员工编码',
	create_user_id BIGINT NULL COMMENT '创建人ID',
    create_date DATE NULL DEFAULT NULL COMMENT '创建时间',
    last_modify_user_id BIGINT  NULL COMMENT '修改人ID',
    last_modify_date DATE NULL DEFAULT NULL COMMENT '修改时间',
    global_unique_no varchar NOT NULL COMMENT '员工编码',
    price decimal NOT NULL COMMENT '价格',
    address decimal NOT NULL COMMENT '地址',
    img1 varchar NOT NULL COMMENT '图片1',
    img2 varchar NOT NULL COMMENT '图片2',
	PRIMARY KEY (evidence_id)
);

