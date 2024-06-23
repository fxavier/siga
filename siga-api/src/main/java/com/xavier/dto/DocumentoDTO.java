package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.xavier.model.Aluno;
import com.xavier.model.TipoDocumento;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDTO {
    private Long id;
    private Aluno aluno;
    private TipoDocumento tipoDocumento;
    private LocalDate dataEmissao;
    private String arquivoDigital;
}
