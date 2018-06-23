/*用户表*/
drop table if exists sys_user; 
create table sys_user(
	user_id int primary key AUTO_INCREMENT,
	user_code varchar(20) not null,
	user_name varchar(20) not null,
	password varchar(50) not null,
	unique (user_code)
);

insert into sys_user(user_code,user_name,password) values('admin','系统管理员',1);

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
insert into module_node(role_code,node_code,node_text)values('admin','userManagement','用户管理');




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
values('admin','userManagement','角色管理','/html/modules/admin/userManagement/roleManagement.html');

insert into module_page(role_code,node_code,page_text,page_url)
values('admin','userManagement','人员管理','/html/modules/admin/userManagement/userManagement.html');





























