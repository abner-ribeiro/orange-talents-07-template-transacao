package com.zup.transacao.dto;

import com.zup.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {
    private String codigoTransacao;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;

    public TransacaoDto(String codigoTransacao, BigDecimal valor, LocalDateTime efetivadaEm) {
        this.codigoTransacao = codigoTransacao;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
    }

    public static Page<TransacaoDto> toDtoPage(Page<Transacao> page){
        return page.map(transacao -> new TransacaoDto(transacao.getCodigoTransacao(), transacao.getValor(), transacao.getEfetivadaEm()));
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
