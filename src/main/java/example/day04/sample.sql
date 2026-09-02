-- Active: 1785826856181@@127.0.0.1@3306@mydb0902
DROP DATABASE IF EXISTS mydb0902;
CREATE DATABASE mydb0902;
use mydb0902;
create table exam(
    eno INT AUTO_INCREMENT PRIMARY KEY ,
    ename VARCHAR(255)
);
 
 insert into exam ( ename )VALUES("유재석");
 insert into exam ( ename )VALUES("강호동");
 insert into exam ( ename )VALUES("신동엽");