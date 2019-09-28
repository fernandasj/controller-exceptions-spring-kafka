package br.edu.ifpb.pweb2.monitorexcecoes.controller;

import br.edu.ifpb.pweb2.monitorexcecoes.model.Excecao;
import br.edu.ifpb.pweb2.monitorexcecoes.service.ExcecaoService;
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
@RequestMapping("excecoes")
@Api(tags = "Gerenciamento de Excecoes")
public class ExcecaoController {

    private final ExcecaoService service;

    public ExcecaoController(ExcecaoService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Criar nova excecao")
    public Excecao criarNovaExcecao(@Valid @RequestBody Excecao excecao) {
        return service.criarExcecao(excecao);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar excecao por id")
    public ResponseEntity<Excecao> buscarExcecao(@PathVariable("id") @ApiParam("Numero de identificacao unica da excecao") Long id) {
        Excecao excecao = service.buscarExcecaoPorId(id);
        if (excecao != null) {
            return ResponseEntity.ok().body(excecao);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remocao de excecoes")
    public void deletarExcecao(@PathVariable("id") @ApiParam("Numero de identificacao unica do usuario") Long id) {
        service.deletarExcecao(id);
    }

    @GetMapping
    @ApiOperation(value = "Listagem de excecoes")
    public List<Excecao> listar() {
        return service.listExcecoes();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar status excecao")
    public Excecao atualizarExcecao(@PathVariable("id") @ApiParam("Identificação única do usuário") Long id, @Valid @RequestBody Excecao excecao, @Valid Excecao.ExcecaoStatus status) {
        return service.atualizarStatusExcecao(id, excecao, status);
    }
}
