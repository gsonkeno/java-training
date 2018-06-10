
create table sys_user(
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  user_name VARCHAR(50) COMMENT '用户名',
  user_password VARCHAR(50) COMMENT '密码',
  user_email VARCHAR(50) COMMENT '邮箱',
  user_info VARCHAR(50) COMMENT '简介',
  head_img BLOB COMMENT '头像',
  create_time DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
);

alter table sys_user COMMENT '用户表';

create table sys_role(
  id BIGINT NOT NULL  AUTO_INCREMENT COMMENT '角色ID',
  role_name VARCHAR(50) COMMENT '角色名',
  enabled int COMMENT '有效标志',
  create_by BIGINT COMMENT '创建人',
  create_time DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
);

alter table sys_role COMMENT '角色表';

create table sys_privilege(
  id BIGINT NOT NULL  AUTO_INCREMENT COMMENT '权限ID',
  privilege_name VARCHAR(50) COMMENT '权限名称',
  privilege_url VARCHAR(200) COMMENT '权限url',
  PRIMARY KEY (id)
);

alter table sys_privilege COMMENT '权限表';

create table sys_user_role(
  user_id BIGINT    COMMENT '用户ID',
  role_id BIGINT    COMMENT '角色ID'
);

alter table sys_user_role COMMENT '用户角色关联表';

create table sys_role_privilege(
  role_id BIGINT    COMMENT '角色ID',
  privilege_id BIGINT    COMMENT '权限ID'
);

alter table sys_role_privilege COMMENT '角色权限关联表';

insert INTO sys_user values (1, 'admin','123456', 'admin@mybatis.com', '管理员', null, '2016-04-01 17:00:58');
insert INTO sys_user values (1001, 'test','123456', 'test@mybatis.com', '测试用户', null, '2016-04-01 17:01:52');

insert INTO sys_role values (1, '管理员', 1,1,'2016-04-01 17:02:14');
insert INTO sys_role values (2, '普通用户', 1,1,'2016-04-01 17:02:34');

insert INTO sys_user_role values (1,1);
insert INTO sys_user_role values (1,2);
insert INTO sys_user_role values (1001,2);

insert into sys_privilege values (1,'用户管理','/users');
insert into sys_privilege values (2,'角色管理','/roles');
insert into sys_privilege values (3,'系统日志','/logs');
insert into sys_privilege values (4,'人员维护','/persons');
insert into sys_privilege values (5,'单位维护','/companies');

insert into sys_role_privilege values (1,1);
insert into sys_role_privilege values (1,2);
insert into sys_role_privilege values (1,3);
insert into sys_role_privilege values (2,4);
insert into sys_role_privilege values (2,5);