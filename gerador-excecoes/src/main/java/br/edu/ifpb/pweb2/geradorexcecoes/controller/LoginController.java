package br.edu.ifpb.pweb2.geradorexcecoes.controller;

import br.edu.ifpb.pweb2.geradorexcecoes.model.Usuario;
import br.edu.ifpb.pweb2.geradorexcecoes.repository.UsuarioRepository;
import br.edu.ifpb.pweb2.geradorexcecoes.security.jwt.JwtTokenProvider;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@Api(tags = "Controlador de Login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest data) throws InterruptedException {

        Map<Object, Object> model = new HashMap<>();

        try {
            String login = data.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, data.getSenha()));
            String token = jwtTokenProvider.createToken(
                    login,
                    this.usuarioRepository.findByLogin(login)
                            .orElseThrow(() -> new UsernameNotFoundException("Usuário: " + login + " não foi encontrado"))
                            .getRoles()
            );
            Optional<Usuario> u = this.usuarioRepository.findByLogin(login);

            model.put("login", login);
            model.put("data_cadastro", u.get().getCadastro());
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            return new ResponseEntity<Json>(
                    new Json("{'timestamp':'" + LocalDateTime.now() + "'," +
                            "'status':'" + HttpStatus.UNAUTHORIZED.value() + "', " +
                            "'error':'Unauthorized'}"),
                    HttpStatus.UNAUTHORIZED
            );
        }
    }
}
