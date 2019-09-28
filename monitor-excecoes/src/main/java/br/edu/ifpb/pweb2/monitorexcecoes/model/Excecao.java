package br.edu.ifpb.pweb2.monitorexcecoes.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Excecao {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @NotBlank
    private String messagem;
    private ZonedDateTime emissao = ZonedDateTime.now();
    @NotEmpty
    @NotBlank
    private String classe;
    @NotEmpty
    @NotBlank
    private String usuario;
    @Enumerated(value = EnumType.STRING)
    private ExcecaoStatus status = ExcecaoStatus.PENDENTE;

    public Excecao(@NotEmpty @NotBlank String messagem, @NotEmpty @NotBlank String classe, @NotEmpty @NotBlank String usuario) {
        this.messagem = messagem;
        this.classe = classe;
        this.usuario = usuario;
    }

    public enum ExcecaoStatus {
        PENDENTE, RESOLVIDA
    }
}
