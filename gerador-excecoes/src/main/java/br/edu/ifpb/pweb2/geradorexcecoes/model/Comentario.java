package br.edu.ifpb.pweb2.geradorexcecoes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @NotBlank
    private String mensagem;

    private ZonedDateTime cadastro;
    private Long excecaoId;

}
