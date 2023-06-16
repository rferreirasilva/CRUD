package com.example.rodrigo.pessoas.controller;

import com.example.rodrigo.pessoas.dto.request.PessoaRequestDTO;
import com.example.rodrigo.pessoas.dto.response.PessoaResponseDTO;
import com.example.rodrigo.pessoas.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> findById(@PathVariable(name = "id") Long id)
    {

        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll()
    {
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody PessoaRequestDTO pessoaRequestDTO, UriComponentsBuilder uriBuilder)
    {
        PessoaResponseDTO pessoaResponseDTO = pessoaService.register(pessoaRequestDTO);
        URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoaResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoaResponseDTO);
    }
    @PutMapping (value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> update(@RequestBody PessoaRequestDTO pessoaDTO, @PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok().body(pessoaService.update(id,pessoaDTO));
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String>delete(@PathVariable(value = "id") Long id)
    {
        return ResponseEntity.ok().body(pessoaService.delete(id));
    }

}
