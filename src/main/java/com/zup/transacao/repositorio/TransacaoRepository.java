package com.zup.transacao.repositorio;

import com.zup.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
    Page<Transacao> findByCartaoCodigoCartao(String codigoCartao, Pageable pageable);
}
