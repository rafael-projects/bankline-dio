package com.dio.santander.apibank.dto;

import com.dio.santander.apibank.model.MovimentacaoTipo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NovaMovimentacao {
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
    private Integer idConta;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoTipo tipo) {
        this.tipo = tipo;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }


}
