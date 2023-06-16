package com.example.rodrigo.pessoas.dto.request;

import lombok.Getter;

import java.util.Date;
@Getter

public class PessoaRequestDTO {

    private String nome;


    private String cpf;

    private Date nascimento;

}
