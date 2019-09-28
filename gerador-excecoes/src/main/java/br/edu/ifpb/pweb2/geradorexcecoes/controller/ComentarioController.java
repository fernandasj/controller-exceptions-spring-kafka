package br.edu.ifpb.pweb2.geradorexcecoes.controller;

import br.edu.ifpb.pweb2.geradorexcecoes.model.Comentario;
import br.edu.ifpb.pweb2.geradorexcecoes.service.ComentarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Component
@RestController
@RequestMapping("comentarios")
@Api(tags = "Gerenciamento de Comentarios")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Criar novo comentario")
    public Comentario criarNovoComentario(@Valid @RequestBody Comentario comentario) {
        return service.criarComentario(comentario);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar comentario por id")
    public ResponseEntity<Comentario> buscarComentario(@PathVariable("id") @ApiParam("Numero de identificacaoo unica do comentario") Long id) {
        Comentario comentario = service.buscarComentarioPorId(id);
        if (comentario != null) {
            return ResponseEntity.ok().body(comentario);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remocao de comentarios")
    public void deletarComentario(@PathVariable("id") @ApiParam("Numero de identificacao unica do comentario") Long id) {
        service.deletarComentario(id);
    }

    @GetMapping
    @ApiOperation(value = "Listagem de excecoes")
    public List<Comentario> listar() {
        return service.listExcecoes();
    }
}
