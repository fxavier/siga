package com.xavier.service;

import java.util.List;
import java.util.Optional;


import com.xavier.dto.AlunoDTO;
import com.xavier.dto.DocumentoDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Aluno;
import com.xavier.model.Documento;
import com.xavier.repository.AlunoRepository;
import com.xavier.repository.DocumentoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class AlunoServiceImpl implements AlunoService {

    @Inject
    private AlunoRepository alunoRepository;
    
    @Inject
    private DocumentoRepository documentoRepository;


    @Override
    @Transactional
    public AlunoDTO create(@Valid AlunoDTO alunoDTO) {
       Aluno aluno = toEntity(alunoDTO);
       alunoRepository.persist(aluno);
       
       List<Documento> documentos = alunoDTO.getDocumentos().stream()
               .map(documentoDTO -> {
                   Documento documento = toEntity(documentoDTO);
                   documento.setAluno(aluno);
                   return documento;
               }).toList();

       documentos.forEach(documentoRepository::persist);

       return toDTO(aluno, documentos);
    }

    @Override
    @Transactional
    public AlunoDTO update(@NotNull Long id, @Valid AlunoDTO alunoDTO) {
       Optional<Aluno> alunoOptional = alunoRepository.findByIdOptional(id);
         if (!alunoOptional.isPresent()) {
              throw new ServiceException("Aluno com id[%s] nao encontrado", id);
         }
         Aluno aluno = alunoOptional.get();
            aluno.setNumero(alunoDTO.getNumero());
            aluno.setPrimeiroNome(alunoDTO.getPrimeiroNome());
            aluno.setSegundoNome(alunoDTO.getSegundoNome());
            aluno.setApelido(alunoDTO.getApelido());
            aluno.setDataNascimento(alunoDTO.getDataNascimento());
            aluno.setGenero(alunoDTO.getGenero());
            aluno.setNacionalidade(alunoDTO.getNacionalidade());
            aluno.setTelefone(alunoDTO.getTelefone());
            aluno.setEmail(alunoDTO.getEmail());
            aluno.setEndereco(alunoDTO.getEndereco());
            aluno.setFoto(alunoDTO.getFoto());

            alunoRepository.persist(aluno);

            return toDTO(aluno);


    }

    @Override
    public AlunoDTO findById(@NotNull Long id) {
        Aluno aluno = alunoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Aluno nao encontrado com id[%s]", id));
        return toDTO(aluno);
    }

    @Override
    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findByIdOptional(id);
        if (!alunoOptional.isPresent()) {
            throw new ServiceException("Aluno com id[%s] nao encontrado", id);
        }
        alunoRepository.delete(alunoOptional.get());
    }

    private AlunoDTO toDTO(Aluno aluno) {

        return AlunoDTO.builder()
                .id(aluno.getId())
                .numero(aluno.getNumero())
                .primeiroNome(aluno.getPrimeiroNome())
                .segundoNome(aluno.getSegundoNome())
                .apelido(aluno.getApelido())
                .dataNascimento(aluno.getDataNascimento())
                .genero(aluno.getGenero())
                .nacionalidade(aluno.getNacionalidade())
                .telefone(aluno.getTelefone())
                .email(aluno.getEmail())
                .endereco(aluno.getEndereco())
                .foto(aluno.getFoto())
                .build();
    }

    private DocumentoDTO toDTO(Documento documento) {
        return DocumentoDTO.builder()
                .id(documento.getId())
                .tipoDocumento(documento.getTipoDocumento())
                .build();
    }

    private Aluno toEntity(AlunoDTO alunoDTO) {
        return Aluno.builder()
                .id(alunoDTO.getId())
                .numero(alunoDTO.getNumero())
                .primeiroNome(alunoDTO.getPrimeiroNome())
                .segundoNome(alunoDTO.getSegundoNome())
                .apelido(alunoDTO.getApelido())
                .dataNascimento(alunoDTO.getDataNascimento())
                .genero(alunoDTO.getGenero())
                .nacionalidade(alunoDTO.getNacionalidade())
                .telefone(alunoDTO.getTelefone())
                .email(alunoDTO.getEmail())
                .endereco(alunoDTO.getEndereco())
                .foto(alunoDTO.getFoto())
                .build();
    }

    private Documento toEntity(DocumentoDTO documentoDTO) {
        return Documento.builder()
                .id(documentoDTO.getId())
                .tipoDocumento(documentoDTO.getTipoDocumento())
                .build();
    }

    private AlunoDTO toDTO(Aluno aluno, List<Documento> documentos) {
        List<DocumentoDTO> documentoDTOs = documentos.stream()
                .map(this::toDTO)
                .toList();

        return AlunoDTO.builder()
                .id(aluno.getId())
                .numero(aluno.getNumero())
                .primeiroNome(aluno.getPrimeiroNome())
                .segundoNome(aluno.getSegundoNome())
                .apelido(aluno.getApelido())
                .dataNascimento(aluno.getDataNascimento())
                .genero(aluno.getGenero())
                .nacionalidade(aluno.getNacionalidade())
                .telefone(aluno.getTelefone())
                .email(aluno.getEmail())
                .endereco(aluno.getEndereco())
                .foto(aluno.getFoto())
                .documentos(documentoDTOs)
                .build();
    }
    
}
