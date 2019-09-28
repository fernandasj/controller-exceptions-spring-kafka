package br.edu.ifpb.pweb2.geradorexcecoes.exception;

import br.edu.ifpb.pweb2.geradorexcecoes.channels.GeradorExcecoesChannels;
import br.edu.ifpb.pweb2.geradorexcecoes.commons.Messagem;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioException {

    private final GeradorExcecoesChannels channels;

    public UsuarioException(GeradorExcecoesChannels channels) {
        this.channels = channels;
    }

    public void usuarioNaoEncontradoException(Messagem mensagem) {
        org.springframework.messaging.Message<Messagem> message = MessageBuilder.withPayload(mensagem).build();
        channels.excecaoSaida().send(message);
    }

    public void senhaFracaException(Messagem mensagem) {
        org.springframework.messaging.Message<Messagem> message = MessageBuilder.withPayload(mensagem).build();
        channels.excecaoSaida().send(message);
    }

    public void falhaInternaException(Messagem mensagem) {
        org.springframework.messaging.Message<Messagem> message = MessageBuilder.withPayload(mensagem).build();
        channels.excecaoSaida().send(message);
    }
}
