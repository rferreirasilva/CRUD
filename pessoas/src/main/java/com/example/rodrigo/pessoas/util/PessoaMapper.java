package com.example.rodrigo.pessoas.util;

import com.example.rodrigo.pessoas.dto.request.PessoaRequestDTO;
import com.example.rodrigo.pessoas.dto.response.PessoaResponseDTO;
import com.example.rodrigo.pessoas.entity.Pessoa;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class PessoaMapper {
    public Pessoa toPessoa(PessoaRequestDTO pessoaDTO)
    {
        return Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .cpf(pessoaDTO.getCpf())
                .nascimento(pessoaDTO.getNascimento())
                .build();
    }
    public PessoaResponseDTO toPessoaDTO(Pessoa pessoa){

        return new PessoaResponseDTO(pessoa);
    }
    public List<PessoaResponseDTO> toPessoaDTO(List<Pessoa>pessoaList)
    {
        return pessoaList.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePessoaData(Pessoa pessoa, PessoaRequestDTO pessoaDTO)
    {
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setNascimento(pessoaDTO.getNascimento());
    }
}