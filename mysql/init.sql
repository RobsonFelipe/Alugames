CREATE DATABASE IF NOT EXISTS alugames;

USE alugames;

CREATE TABLE IF NOT EXISTS jogos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    capa VARCHAR(255),
    descricao VARCHAR(255),
    preco DOUBLE,
    titulo VARCHAR(100)
);