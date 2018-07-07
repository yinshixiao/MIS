/*用户表*/
CREATE SEQUENCE sys_user_id increment by 1 start with 1 nomaxvalue  minvalue 1 NOCYCLE;     
create  table sys_user(
	user_id int primary key,
	user_code varchar(20) not null,
	user_name varchar(20) not null,
	password varchar(50) not null,
	is_enabled varchar(1) default 'N', 
	unique (user_code)
);

insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'admin','系统管理员',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test1','测试用户1',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test2','测试用户2',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test3','测试用户3',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test4','测试用户4',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test5','测试用户5',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test6','测试用户6',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test7','测试用户7',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test8','测试用户8',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test9','测试用户9',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test10','测试用户10',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test11','测试用户11',1);
insert into sys_user(user_id,user_code,user_name,password) values(sys_user_id.nextval,'test12','测试用户12',1);


/*角色表*/ 
CREATE SEQUENCE sys_role_id increment by 1 start with 1 nomaxvalue  minvalue 1 NOCYCLE;
create table sys_role(
	role_id int primary key,
	role_code varchar(20) not null,
	role_name varchar(20) not null,
	unique (role_code),
	unique (role_name)
);
begin
	insert into sys_role(role_id,role_code,role_name) values(sys_role_id.nextval,'admin','系统管理员');
end;


/*用户与角色关联表（一个用户可以拥有多个角色）*/
CREATE SEQUENCE user_link_role_id increment by 1 start with 1 nomaxvalue  minvalue 1 NOCYCLE;
create table user_link_role(
	link_id int primary key,
	user_code varchar(20) not null,
	role_code varchar(20) not null
);
insert into user_link_role(link_id,user_code,role_code) values(user_link_role_id.nextval,'admin','admin');


/*菜单文件夹节点*/
CREATE SEQUENCE module_node_id increment by 1 start with 1 nomaxvalue  minvalue 1 NOCYCLE;
create table module_node(
	node_id int primary key ,
	role_code varchar(20) not null,
	node_code  varchar(20) not null,
	node_text varchar(30) not null
);
insert into module_node(node_id,role_code,node_code,node_text)values(module_node_id.nextval,'admin','loginSystem','用户管理');




/*菜单中的页面节点*/
CREATE SEQUENCE module_page_id increment by 1 start with 1 nomaxvalue  minvalue 1 NOCYCLE;
create table module_page(
	page_id int primary key ,
	role_code varchar(20) not null,
	node_code varchar(20) not null,
	page_text varchar(30) not null,
	page_url varchar(400) not null
);

insert into module_page(page_id,role_code,node_code,page_text,page_url)
values(module_page_id.nextval,'admin','loginSystem','角色管理','/html/admin/loginSystem/roleManagement.html');

insert into module_page(page_id,role_code,node_code,page_text,page_url)
values(module_page_id.nextval,'admin','loginSystem','人员管理','/html/admin/loginSystem/userManagement.html');





























