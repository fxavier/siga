package com.xavier.service;

import java.util.List;

import com.xavier.dto.MaeDTO;

public interface MaeService {
    MaeDTO create(MaeDTO maeDTO);
    MaeDTO update(Long id, MaeDTO maeDTO);
    List<MaeDTO> findAll();
    MaeDTO findById(Long id);
    void delete(Long id);

    
}
