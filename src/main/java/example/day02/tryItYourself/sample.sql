DROP DATABASE IF EXISTS mydb08262;
CREATE DATABASE mydb08262;
USE mydb08262;
CREATE TABLE board( 
    no int AUTO_INCREMENT , 
    phone VARCHAR(20) ,
    people int not null,
    constraint PRIMARY KEY( no ) 
);
insert into board( phone, people )values( "010-1234-5678", 5 ),( "010-1234-5679", 7); -- 샘플 데이터 2개