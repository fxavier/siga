package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.xavier.model.Genero;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long id;
    private String primeiroNome;
    private String segundoNome;
    private String apelido;
    private Genero genero;
    private LocalDate dataNascimento;
    private Long nacionalidadeId;
    private String telefone;
    private String email;
    private String endereco;
    private String foto;
}
