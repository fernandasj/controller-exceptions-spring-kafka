package br.edu.ifpb.pweb2.monitorexcecoes.handle;

import br.edu.ifpb.pweb2.monitorexcecoes.channels.MonitorExcecoesChannels;
import br.edu.ifpb.pweb2.monitorexcecoes.commons.ComentarioMensagem;
import br.edu.ifpb.pweb2.monitorexcecoes.commons.Messagem;
import br.edu.ifpb.pweb2.monitorexcecoes.model.Excecao;
import br.edu.ifpb.pweb2.monitorexcecoes.service.ExcecaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExceptionHandle {

    private final ExcecaoService service;

    public ExceptionHandle(ExcecaoService service) {
        this.service = service;
    }

    @StreamListener(value = MonitorExcecoesChannels.MONITOR_ENTRADA)
    @SendTo(value = MonitorExcecoesChannels.MONITOR_SAIDA)
    public ComentarioMensagem getExcptions(@Payload Messagem mensagem) {
        Excecao excecao = service.criarExcecao(new Excecao(mensagem.getMensagem(), mensagem.getClasse(), mensagem.getLogin()));

        return ComentarioMensagem.builder()
                .excecaoId(excecao.getId())
                .message(excecao.getMessagem())
                .build();
    }
}
