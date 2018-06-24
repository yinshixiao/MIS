/*用户表*/
drop table if exists sys_user; 
create table sys_user(
	user_id int primary key AUTO_INCREMENT,
	user_code varchar(20) not null,
	user_name varchar(20) not null,
	password varchar(50) not null,
	is_enabled varchar(1) default 'N', 
	unique (user_code)
);

insert into sys_user(user_code,user_name,password) values('admin','系统管理员',1);
insert into sys_user(user_code,user_name,password) values('test1','测试用户1',1);
insert into sys_user(user_code,user_name,password) values('test2','测试用户2',1);
insert into sys_user(user_code,user_name,password) values('test3','测试用户3',1);
insert into sys_user(user_code,user_name,password) values('test4','测试用户4',1);
insert into sys_user(user_code,user_name,password) values('test5','测试用户5',1);
insert into sys_user(user_code,user_name,password) values('test6','测试用户6',1);
insert into sys_user(user_code,user_name,password) values('test7','测试用户7',1);
insert into sys_user(user_code,user_name,password) values('test8','测试用户8',1);
insert into sys_user(user_code,user_name,password) values('test9','测试用户9',1);
insert into sys_user(user_code,user_name,password) values('test10','测试用户10',1);
insert into sys_user(user_code,user_name,password) values('test11','测试用户11',1);
insert into sys_user(user_code,user_name,password) values('test12','测试用户12',1);


/*角色表*/
drop table if exists sys_role; 
create table sys_role(
	role_id int primary key auto_increment,
	role_code varchar(20) not null,
	role_name varchar(20) not null,
	unique (role_code),
	unique (role_name)
);
insert into sys_role(role_code,role_name) values('admin','系统管理员');



/*用户与角色关联表（一个用户可以拥有多个角色）*/
drop table if exists user_link_role; 
create table user_link_role(
	link_id int primary key auto_increment,
	user_code varchar(20) not null,
	role_code varchar(20) not null
);
insert into user_link_role(user_code,role_code) values('admin','admin');


/*菜单文件夹节点*/
drop table if exists module_node; 
create table module_node(
	node_id int primary key auto_increment,
	role_code varchar(20) not null,
	node_code  varchar(20) not null,
	node_text varchar(30) not null
);
insert into module_node(role_code,node_code,node_text)values('admin','loginSystem','用户管理');




/*菜单中的页面节点*/
drop table if exists module_page; 
create table module_page(
	page_id int primary key auto_increment,
	role_code varchar(20) not null,
	node_code varchar(20) not null,
	page_text varchar(30) not null,
	page_url varchar(400) not null
);
insert into module_page(role_code,node_code,page_text,page_url)
values('admin','loginSystem','角色管理','/html/admin/loginSystem/roleManagement.html');

insert into module_page(role_code,node_code,page_text,page_url)
values('admin','loginSystem','人员管理','/html/admin/loginSystem/userManagement.html');





























