package br.edu.ifpb.pweb2.monitorexcecoes.commons;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Messagem {

    private String login;
    private String mensagem;
    private String classe;
}
