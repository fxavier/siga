package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import java.util.List;

import com.xavier.model.Country;
import com.xavier.model.Genero;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    private Long id;
    private String numero;
    @NotEmpty(message = "{Object.required}")
    private String primeiroNome;
    private String segundoNome;
    @NotEmpty(message = "{Object.required}")
    private String apelido;
    @NotNull(message = "{Object.obj.required}")
    private Genero genero;
    @NotNull(message = "{Object.data.required}")
    private LocalDate dataNascimento;
    @NotNull(message = "{Object.obj.required}")
    private Country nacionalidade;
    private String telefone;
    @Email(message = "{Object.email.invalid}")
    private String email;
    @NotEmpty(message = "{Object.required}")
    private String endereco;
    private String foto;
    private List<DocumentoDTO> documentos;
}
