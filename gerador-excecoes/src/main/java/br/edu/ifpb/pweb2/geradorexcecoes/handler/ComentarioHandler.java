package br.edu.ifpb.pweb2.geradorexcecoes.handler;

import br.edu.ifpb.pweb2.geradorexcecoes.channels.GeradorExcecoesChannels;
import br.edu.ifpb.pweb2.geradorexcecoes.commons.ComentarioMensagem;
import br.edu.ifpb.pweb2.geradorexcecoes.model.Comentario;
import br.edu.ifpb.pweb2.geradorexcecoes.service.ComentarioService;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class ComentarioHandler {

    private final ComentarioService service;

    public ComentarioHandler(ComentarioService service) {
        this.service = service;
    }

    @StreamListener(value = GeradorExcecoesChannels.EXCECAO_ENTRADA)
    public void handle(@Payload ComentarioMensagem messagem) {
        service.criarComentario(Comentario.builder()
                .excecaoId(messagem.getExcecaoId())
                .mensagem(messagem.getMessage())
                .cadastro(ZonedDateTime.now())
                .build());
    }

}
