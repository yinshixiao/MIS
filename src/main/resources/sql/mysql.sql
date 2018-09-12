/*用户表*/
create  table sys_user(
	user_id int primary key,
	user_code varchar(20) not null,
	user_name varchar(20) not null,
	password varchar(50) not null,
	is_stop varchar(1) default 'N', 
	unique (user_code)
);