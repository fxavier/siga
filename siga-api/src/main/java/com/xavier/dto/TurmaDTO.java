package com.xavier.dto;

import com.xavier.model.Classe;
import com.xavier.model.Turno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {
    private Long id;
    private String codigo;
    private String designacao;
    private String anoLectivo;
    private Turno turno;
    private String sala;
    private Classe classe;
}
