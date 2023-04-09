drop database if exists magazine_shop;
create database magazine_shop;
use magazine_shop;


create table employee (
	id int primary key auto_increment,
    name varchar(50),
    lastName varchar(50) 
);

create table magazine (
	id int primary key auto_increment,
    name varchar(50),
    publish_date date,
    price double
);

