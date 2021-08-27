package com.zup.transacao.repositorio;

import com.zup.transacao.modelo.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
}
