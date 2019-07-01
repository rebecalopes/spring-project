create database gfood;
CREATE TABLE cliente(
	ID INTEGER NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    ENDERECO VARCHAR(200),
    PRIMARY KEY (ID)
);
SELECT * FROM produto;
use gfood;
CREATE TABLE produto(
                        ID INTEGER NOT NULL AUTO_INCREMENT,
                        NOME VARCHAR(200) NOT NULL,
                        DESCRICAO TEXT,
                        PRIMARY KEY (ID)
);


