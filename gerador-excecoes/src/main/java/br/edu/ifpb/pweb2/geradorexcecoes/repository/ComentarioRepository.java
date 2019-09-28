package br.edu.ifpb.pweb2.geradorexcecoes.repository;

import br.edu.ifpb.pweb2.geradorexcecoes.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
