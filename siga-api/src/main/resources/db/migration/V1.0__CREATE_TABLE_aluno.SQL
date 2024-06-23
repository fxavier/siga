CREATE TABLE aluno (
    id BIGSERIAL NOT NULL,
    primeiro_nome VARCHAR(255),
    segundo_nome VARCHAR(255),
    apelido VARCHAR(255),
    genero VARCHAR(255) CHECK (genero IN ('MASCULINO', 'FEMININO')),  
    data_nascimento DATE,
    telefone VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255),
    PRIMARY KEY (id)
);