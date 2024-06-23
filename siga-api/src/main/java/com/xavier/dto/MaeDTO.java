package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaeDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
}
