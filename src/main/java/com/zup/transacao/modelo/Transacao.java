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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String transacaoId;
    @NotNull @Positive
    private BigDecimal valor;
    @NotNull @ManyToOne(cascade = {CascadeType.PERSIST})
    private Estabelecimento estabelecimento;
    @NotNull @ManyToOne(cascade = {CascadeType.PERSIST})
    private Cartao cartao;
    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao(){}

    public Transacao(String transacaoId, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.transacaoId = transacaoId;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}
