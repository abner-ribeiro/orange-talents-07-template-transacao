package com.zup.transacao.modelo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {
    @Id
    private String codigoCartao;
    @NotBlank @Email
    private String email;

    @Deprecated
    public Cartao(){}

    public Cartao(String codigoCartao, String email) {
        this.codigoCartao = codigoCartao;
        this.email = email;
    }
}
