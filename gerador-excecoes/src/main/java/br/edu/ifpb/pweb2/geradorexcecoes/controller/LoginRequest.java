package br.edu.ifpb.pweb2.geradorexcecoes.controller;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = -6986746375915710855L;
    private String login;
    private String senha;

}