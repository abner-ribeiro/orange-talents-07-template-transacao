package com.zup.transacao.controller;

import com.zup.transacao.dto.TransacaoDto;
import com.zup.transacao.modelo.Cartao;
import com.zup.transacao.modelo.Transacao;
import com.zup.transacao.repositorio.CartaoRepository;
import com.zup.transacao.repositorio.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class TransacaoController {
    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/{cartaoId}/transacoes")
    public ResponseEntity listarCompras(@PathVariable String cartaoId, Pageable pageable){
        Optional<Cartao> possivelCartao = cartaoRepository.findByCodigoCartao(cartaoId);

        if(possivelCartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Page<Transacao> compras = transacaoRepository.findByCartaoCodigoCartao(cartaoId,pageable);

        return ResponseEntity.ok(TransacaoDto.toDtoPage(compras));
    }
}
