package com.xavier.dto;

import com.xavier.model.Aluno;
import com.xavier.model.StatusInscricao;
import com.xavier.model.Turma;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscricaoDTO {
    private Long id;
    private Integer anoLectivo;
    private Aluno aluno;
    private Turma turma;
    private StatusInscricao statusInscricao;
}
