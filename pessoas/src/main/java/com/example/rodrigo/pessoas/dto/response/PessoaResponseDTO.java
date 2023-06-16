package com.example.rodrigo.pessoas.dto.response;

import com.example.rodrigo.pessoas.entity.Pessoa;
import lombok.Getter;

import java.util.Date;

@Getter

public class PessoaResponseDTO {
    private Long id;


    private String nome;


    private String cpf;

    private Date nascimento;

    public PessoaResponseDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.nascimento = pessoa.getNascimento();
    }
}