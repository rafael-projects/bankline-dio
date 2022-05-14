package com.dio.santander.apibank.controller;


import com.dio.santander.apibank.dto.NovaMovimentacao;
import com.dio.santander.apibank.dto.NovoCorrentista;
import com.dio.santander.apibank.model.Correntista;
import com.dio.santander.apibank.model.Movimentacao;
import com.dio.santander.apibank.repository.CorrentistaRepository;
import com.dio.santander.apibank.repository.MovimentacaoRepository;
import com.dio.santander.apibank.service.CorrentistaService;
import com.dio.santander.apibank.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){

        service.save(movimentacao);
    }
}
