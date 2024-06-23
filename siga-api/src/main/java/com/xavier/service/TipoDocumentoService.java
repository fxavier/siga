package com.xavier.service;

import com.xavier.dto.TipoDocumentoDTO;
import java.util.List;

public interface TipoDocumentoService {
    TipoDocumentoDTO create(TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumentoDTO update(Long id, TipoDocumentoDTO tipoDocumentoDTO);
    List<TipoDocumentoDTO> findAll();
    TipoDocumentoDTO findById(Long id);
    void delete(Long id);
}


