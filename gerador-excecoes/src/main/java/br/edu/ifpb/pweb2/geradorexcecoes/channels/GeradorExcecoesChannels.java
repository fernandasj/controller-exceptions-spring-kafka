package br.edu.ifpb.pweb2.geradorexcecoes.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface GeradorExcecoesChannels {

    String EXCECAO_ENTRADA = "monitorSaida";
    String EXCECAO_SAIDA = "excecaoSaida";

    @Input(EXCECAO_ENTRADA)
    SubscribableChannel excecaoEntrada();

    @Output(EXCECAO_SAIDA)
    MessageChannel excecaoSaida();


}
