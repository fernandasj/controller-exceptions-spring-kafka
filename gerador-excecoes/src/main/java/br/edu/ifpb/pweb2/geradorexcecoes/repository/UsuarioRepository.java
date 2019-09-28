package br.edu.ifpb.pweb2.geradorexcecoes.repository;

import br.edu.ifpb.pweb2.geradorexcecoes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}
