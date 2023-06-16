package com.example.rodrigo.pessoas.service;

import com.example.rodrigo.pessoas.dto.request.PessoaRequestDTO;
import com.example.rodrigo.pessoas.dto.response.PessoaResponseDTO;

import java.util.List;

public interface PessoaService {
    PessoaResponseDTO findById(Long id);
    List<PessoaResponseDTO> findAll();

    PessoaResponseDTO register(PessoaRequestDTO pessoaDTO);//insert

    PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO);//update

    String delete(Long id);//delete
}