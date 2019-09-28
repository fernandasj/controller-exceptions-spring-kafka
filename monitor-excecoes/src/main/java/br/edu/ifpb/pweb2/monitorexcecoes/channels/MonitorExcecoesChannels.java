package br.edu.ifpb.pweb2.monitorexcecoes.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MonitorExcecoesChannels {

    String MONITOR_ENTRADA = "excecaoSaida";
    String MONITOR_SAIDA = "monitorSaida";

    @Input(MONITOR_ENTRADA)
    SubscribableChannel monitorEntrada();

    @Output(MONITOR_SAIDA)
    MessageChannel monitorSaida();


}
