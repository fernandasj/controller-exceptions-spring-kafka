package br.edu.ifpb.pweb2.monitorexcecoes.service;

import br.edu.ifpb.pweb2.monitorexcecoes.model.Excecao;
import br.edu.ifpb.pweb2.monitorexcecoes.repositories.ExcecaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcecaoService {

    private final ExcecaoRepository repository;

    public ExcecaoService(ExcecaoRepository repository) {
        this.repository = repository;
    }

    public Excecao criarExcecao(Excecao excecao) {
        return repository.save(excecao);
    }

    public Excecao buscarExcecaoPorId(Long id) {
        return repository.findById(id).get();
    }

    public void deletarExcecao(Long id) {
        repository.deleteById(id);
    }

    public List<Excecao> listExcecoes() {
        return repository.findAll();
    }

    public Excecao atualizarStatusExcecao(Long id, Excecao excecao, Excecao.ExcecaoStatus status) {
        excecao.setId(id);
        excecao.setStatus(status);
        return repository.save(excecao);
    }
}
