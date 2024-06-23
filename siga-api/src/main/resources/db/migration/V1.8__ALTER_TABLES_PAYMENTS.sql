ALTER TABLE IF EXISTS pagamentos ALTER column valor SET DATA TYPE NUMERIC(38,2);
CREATE SEQUENCE TransacaoFinanceira_SEQ START WITH 1 increment by 50;

CREATE TABLE turma_aluno (
    turma_id BIGINT,
    aluno_id BIGINT,
    CONSTRAINT fk_turma_aluno FOREIGN KEY (turma_id) REFERENCES turma(id),
    CONSTRAINT fk_aluno_turma FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

CREATE TABLE turma_professor (
    turma_id BIGINT,
    professor_id BIGINT,
    CONSTRAINT fk_turma_professor FOREIGN KEY (turma_id) REFERENCES turma(id),
    CONSTRAINT fk_professor_turma FOREIGN KEY (professor_id) REFERENCES professor(id)
);