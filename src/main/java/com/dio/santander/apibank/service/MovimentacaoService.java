package com.dio.santander.apibank.service;

import com.dio.santander.apibank.dto.NovaMovimentacao;
import com.dio.santander.apibank.model.Correntista;
import com.dio.santander.apibank.model.Movimentacao;
import com.dio.santander.apibank.model.MovimentacaoTipo;
import com.dio.santander.apibank.repository.CorrentistaRepository;
import com.dio.santander.apibank.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;
    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao =new Movimentacao();

        Double valor = novaMovimentacao.getTipo() ==
                MovimentacaoTipo.RECEITA ?
                novaMovimentacao.getValor() :
                novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescrcao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(novaMovimentacao.getValor());

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);
    }
}
