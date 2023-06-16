package com.example.rodrigo.pessoas.service;

import com.example.rodrigo.pessoas.dto.request.PessoaRequestDTO;
import com.example.rodrigo.pessoas.dto.response.PessoaResponseDTO;
import com.example.rodrigo.pessoas.entity.Pessoa;
import com.example.rodrigo.pessoas.repository.PessoaRepository;
import com.example.rodrigo.pessoas.util.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor

public class PessoaServiceImpl implements PessoaService{

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @Override
    public PessoaResponseDTO findById(Long id) {
        return pessoaMapper.toPessoaDTO(returnPessoa(id));
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return pessoaMapper.toPessoaDTO(pessoaRepository.findAll());
    }

    @Override
    public PessoaResponseDTO register(PessoaRequestDTO pessoaDTO) {

        Pessoa pessoa = pessoaMapper.toPessoa(pessoaDTO);

        return pessoaMapper.toPessoaDTO(pessoaRepository.save(pessoa));
    }

    @Override
    public PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO) {

        Pessoa pessoa = returnPessoa(id);

        pessoaMapper.updatePessoaData(pessoa,pessoaDTO);


        return pessoaMapper.toPessoaDTO(pessoaRepository.save(pessoa));
    }

    @Override
    public String delete(Long id) {
        pessoaRepository.deleteById(id);
        return "Pessoa id:" + id + " excluida";
    }

    private Pessoa returnPessoa(Long id){
        return pessoaRepository.findById(id).orElseThrow(()-> new RuntimeException("Não existe o cadastro desta pessoa"));
    }
}