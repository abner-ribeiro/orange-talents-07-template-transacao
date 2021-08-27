package com.zup.transacao.modelo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String cartaoId;
    @NotBlank @Email
    private String email;

    @Deprecated
    public Cartao(){}

    public Cartao(String cartaoId, String email) {
        this.cartaoId = cartaoId;
        this.email = email;
    }
}
