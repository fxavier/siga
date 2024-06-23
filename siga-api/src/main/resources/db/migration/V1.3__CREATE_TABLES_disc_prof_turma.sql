
CREATE TABLE classe (
    id SERIAL PRIMARY KEY,
    designacao VARCHAR(255),
    sigla VARCHAR(255),
    descricao TEXT
);

CREATE TABLE disciplina (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(255),
    designacao VARCHAR(255),
    classe_id INT NOT NULL,
    CONSTRAINT fk_classe FOREIGN KEY (classe_id) REFERENCES classe(id)
);

CREATE TABLE country (
    id BIGSERIAL PRIMARY KEY,
    country_code VARCHAR(255),
    country_name VARCHAR(255)
);

CREATE TABLE professor (
    id BIGSERIAL PRIMARY KEY,
    primeiro_nome VARCHAR(255),
    segundo_nome VARCHAR(255),
    apelido VARCHAR(255),
    genero VARCHAR(255) CHECK (genero IN ('MASCULINO', 'FEMININO')), 
    data_nascimento DATE,
    nacionalidade_id BIGINT,
    telefone VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255),
    foto TEXT,
    CONSTRAINT fk_nacionalidade FOREIGN KEY (nacionalidade_id) REFERENCES country(id)
);

CREATE TABLE turma (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(255),
    designacao VARCHAR(255),
    ano_lectivo VARCHAR(255),
    turno VARCHAR(255) CHECK (turno IN ('MANHA', 'TARDE', 'POSLABORAL')), 
    sala VARCHAR(255),
    classe_id BIGINT,
    CONSTRAINT fk_classe FOREIGN KEY (classe_id) REFERENCES classe(id)
);

ALTER TABLE aluno ADD COLUMN nacionalidade_id BIGINT;
