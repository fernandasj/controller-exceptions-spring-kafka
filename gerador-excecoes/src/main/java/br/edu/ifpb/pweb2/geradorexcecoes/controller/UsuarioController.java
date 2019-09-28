package br.edu.ifpb.pweb2.geradorexcecoes.controller;

import br.edu.ifpb.pweb2.geradorexcecoes.model.Usuario;
import br.edu.ifpb.pweb2.geradorexcecoes.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Component
@RestController
@RequestMapping("usuarios")
@Api(tags = "Gerenciamento de Usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Criar novo usuario")
    public Usuario criarNovoUsuario(@Valid @RequestBody Usuario usuario) {
        return service.criarUsuario(usuario);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar usuario por id")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") @ApiParam("Numero de identificacaoo unica do usuario") Long id) {
        Usuario usuario = service.buscarUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok().body(usuario);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remoção de usuários")
    public void deletarUsuario(@PathVariable("id") @ApiParam("Numero de identificacao unica do usuario") Long id) {
        service.deletarUsuario(id);
    }
}
