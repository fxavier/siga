package com.xavier.service;

import java.util.List;
import java.util.Optional;

import com.xavier.model.Mae;
import com.xavier.dto.MaeDTO;
import com.xavier.repository.MaeRepository;
import com.xavier.service.exception.MaeException;   

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MaeServiceImpl implements MaeService {

   @Inject
    private MaeRepository maeRepository;

    @Override
    @Transactional
    public MaeDTO create(MaeDTO maeDTO) {
        if(existsMae(maeDTO.getNome())) {
            throw new MaeException("Mae com esse nome ja existe");
        }

        Mae mae = toEntity(maeDTO);
        maeRepository.persist(mae);
        return toDTO(mae);

    }

    @Override
    @Transactional
    public MaeDTO update(Long id, MaeDTO maeDTO) {
        Optional<Mae> maeOptional = maeRepository.findByIdOptional(id);
        if (!maeOptional.isPresent()) {
            throw new MaeException("Mae nao encontrado");
        }
        Mae mae = maeOptional.get();
        mae.setNome(maeDTO.getNome());
        mae.setEmail(maeDTO.getEmail());
        mae.setTelefone(maeDTO.getTelefone());
        mae.setEndereco(maeDTO.getEndereco());
        return toDTO(mae);
    }

    @Override
    public List<MaeDTO> findAll() {
       return maeRepository.listAll()
              .stream()
              .map(this::toDTO)
              .toList();
    }

    @Override
    public MaeDTO findById(Long id) {
        Optional<Mae> maeOptional = maeRepository.findByIdOptional(id);
        if (!maeOptional.isPresent()) {
           throw new MaeException("Mae nao encontrada");
        }
        Mae mae = maeOptional.get();
        return toDTO(mae);
    }

    @Override
    public void delete(Long id) {
        Optional<Mae> maeOptional = maeRepository.findByIdOptional(id);
        if (!maeOptional.isPresent()) {
           throw new MaeException("Mae nao encontrada");
        }
        Mae mae = maeOptional.get();
        maeRepository.delete(mae);
    }

    private MaeDTO toDTO(Mae mae) {
        return MaeDTO
                .builder()
                .id(mae.getId())
                .nome(mae.getNome())
                .telefone(mae.getTelefone())
                .email(mae.getEmail())
                .endereco(mae.getEndereco())
                .build();
    }
    
    private Mae toEntity(MaeDTO maeDTO) {
        return Mae
                .builder()
                .id(maeDTO.getId())
                .nome(maeDTO.getNome())
                .telefone(maeDTO.getTelefone())
                .email(maeDTO.getEmail())
                .endereco(maeDTO.getEndereco())
                .build();
    }

    private boolean existsMae(String nome) {
        return maeRepository.findByName(nome) != null;
    }
}
