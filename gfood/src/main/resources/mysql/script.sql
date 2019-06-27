create database gfood;
CREATE TABLE cliente(
	ID INTEGER NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    ENDERECO VARCHAR(200),
    PRIMARY KEY (ID)
);
SELECT * FROM CLIENTE;

INSERT INTO CLIENTE(NOME, ENDERECO)
VALUES ("Pedro Tomatinho", "Rua Barbaridade, 157"),
("Juca Peripécia", "Rua Junqueira, 157");