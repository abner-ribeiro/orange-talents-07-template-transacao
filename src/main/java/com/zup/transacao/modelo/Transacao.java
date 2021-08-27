package com.zup.transacao.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    private String codigoTransacao;
    @NotNull @Positive
    private BigDecimal valor;
    @NotNull @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Estabelecimento estabelecimento;
    @NotNull @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cartao cartao;
    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao(){}

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao(String codigoTransacao, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.codigoTransacao = codigoTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}
