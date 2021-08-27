package com.zup.transacao.dto;

import com.zup.transacao.modelo.Cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoRequest {
    @NotBlank
    private String id;
    @NotBlank @Email
    private String email;

    @Deprecated
    public CartaoRequest(){}

    public CartaoRequest(String id, String email) {
        this.id = id;
        this.email = email;
    }
    public Cartao toModel(){
        return new Cartao(id,email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
