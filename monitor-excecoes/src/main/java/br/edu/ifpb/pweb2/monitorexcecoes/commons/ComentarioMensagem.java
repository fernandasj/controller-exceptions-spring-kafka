package br.edu.ifpb.pweb2.monitorexcecoes.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioMensagem {

    private String message;
    private Long excecaoId;

}
