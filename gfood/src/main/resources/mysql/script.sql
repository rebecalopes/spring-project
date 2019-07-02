create database gfood;
use gfood;
create table cliente(
	id integer auto_increment not null ,
    nome varchar(200) not null,
    endereco varchar(300),
    data_nascimento date not null,
    primary key (id)
);
 create table produto(
     id integer auto_increment not null,
     nome varchar(200) not null,
     descricao varchar(300),
     preco decimal not null
 );
select * from produto;

