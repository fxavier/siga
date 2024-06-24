package com.xavier.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.xavier.model.Aluno;
import com.xavier.model.TipoDocumento;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class DocumentoDTO {
    private Long id;
    private Aluno aluno;
    private TipoDocumento tipoDocumento;
    private LocalDate dataEmissao;
    private String arquivoDigital;
}
