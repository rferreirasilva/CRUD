package com.example.rodrigo.pessoas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;
import lombok.Getter; //propriedades lombok
import lombok.NoArgsConstructor;
import lombok.Setter; //propriedades lombok

import java.util.Date;


@Entity //indicando ligação com o DB
@Table(name = "pessoa")
@NoArgsConstructor //dependência lombok
@Getter //propriedade dependência lombok
@Setter //propriedade dependência lombok


public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)//para não deixar alterar o id
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "nascimento", nullable = false)
    private Date nascimento;

    @Builder
    public Pessoa(String nome, String cpf, Date nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }
}
