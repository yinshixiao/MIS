/*用户表*/
create table sys_user(
	user_id int primary key AUTO_INCREMENT,
	user_code varchar(20) not null,
	user_name varchar(20) not null,
	password varchar(50) not null,
	unique (user_code)
);

insert into sys_user(user_code,user_name,password) values('admin','系统管理员',1);

/*角色表*/
create table sys_role(
	role_id int primary key auto_increment,
	role_code varchar(20) not null,
	role_name varchar(20) not null,
	unique (role_code),
	unique (role_name)
);
insert into sys_role(role_code,role_name) values('admin','系统管理员');



/*用户与角色关联表（一个用户可以拥有多个角色）*/
create table user_link_role(
	link_id int primary key auto_increment,
	user_code varchar(20) not null,
	role_code varchar(20) not null
);
insert into user_link_role(user_code,role_code) values('admin','admin');
































