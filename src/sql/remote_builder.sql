drop database if exists remote_builder;
create database remote_builder;
use remote_builder;
drop table if exists user_info;
CREATE TABLE user_info(
	id			INT	zerofill auto_increment PRIMARY KEY,
	name		VARCHAR(20)	NOT NULL unique key,
	password		VARCHAR(60)	NOT NULL,
    phone	varchar(11) not null unique key,
    head_sculpture VARCHAR(200),
    before_last_login_time datetime,
    last_login_time datetime ,
    login_device_token VARCHAR(200)
);
insert into user_info (name,password,phone)values("luyunming","1234567890","15708464677");

select * from user_info;
