-- Active: 1785826856181@@127.0.0.1@3306@testdb0902
drop DATABASE IF EXISTS testdb0902;
CREATE DATABASE testdb0902;

use testdb0902;

create table test(
    eno INT AUTO_INCREMENT PRIMARY KEY,
    econtent VARCHAR(255),
    ewriter VARCHAR(20)
);

insert INTO test( econtent , ewriter)VALUES("안녕하세요","유재석");
insert INTO test( econtent , ewriter)VALUES("안녕하세요2","강호동");
