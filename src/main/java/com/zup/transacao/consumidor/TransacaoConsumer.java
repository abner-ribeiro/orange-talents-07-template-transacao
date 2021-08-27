package com.zup.transacao.consumidor;

import com.zup.transacao.dto.TransacaoRequest;
import com.zup.transacao.modelo.Transacao;
import com.zup.transacao.repositorio.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", containerFactory = "kafkaListenerContainerFactory")
    public void ouvir(@Payload TransacaoRequest transacaoRequest) {
        Transacao transacao = transacaoRequest.toModel();
        transacaoRepository.save(transacao);
    }
}
