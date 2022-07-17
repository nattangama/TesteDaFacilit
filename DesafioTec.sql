create database desafiotec;
show databases;
use desafiotec;
create table contatos(
   idcon int primary key auto_increment,
   nome varchar (200) not null,
   email varchar (15) not null,
   informacao varchar (50)
);
show tables;
describe contatos;

/* CRUD CREATE */
insert into contatos (nome, email, informacao) values ('Bill gates', '9999-1111', 'bill@hotmail.com');
/* CRUD READ */
select * from contatos;