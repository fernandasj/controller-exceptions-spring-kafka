package br.edu.ifpb.pweb2.geradorexcecoes.service;

import br.edu.ifpb.pweb2.geradorexcecoes.model.Comentario;
import br.edu.ifpb.pweb2.geradorexcecoes.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    public Comentario criarComentario(Comentario comentario) {
        return repository.save(comentario);
    }

    public Comentario buscarComentarioPorId(Long id) {
        return repository.findById(id).get();
    }

    public void deletarComentario(Long id) {
        repository.deleteById(id);
    }

    public List<Comentario> listExcecoes() {
        return repository.findAll();
    }
}
