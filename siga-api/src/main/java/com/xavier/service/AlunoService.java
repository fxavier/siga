package com.xavier.service;

import com.xavier.dto.AlunoDTO;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public interface AlunoService {

    AlunoDTO create(@Valid AlunoDTO alunoDTO);
    AlunoDTO update(@NotNull Long id, @Valid AlunoDTO alunoDTO);
    AlunoDTO findById(@NotNull Long id);
    List<AlunoDTO> findAll();
    void delete(@NotNull Long id);
    
}
