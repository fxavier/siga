package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTO {
    private Long id;
    private String nome;
    private Integer cargaHoraria;
    private String ementa;
}
