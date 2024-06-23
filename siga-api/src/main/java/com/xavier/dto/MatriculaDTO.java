package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.xavier.model.Aluno;
import com.xavier.model.Classe;
import com.xavier.model.StatusMatricula;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {
    private Long id;
    private Integer anoLectivo;
    private Aluno aluno;
    private Classe classe;
    private LocalDate dataMatricula;
    private StatusMatricula statusMatricula;
}
