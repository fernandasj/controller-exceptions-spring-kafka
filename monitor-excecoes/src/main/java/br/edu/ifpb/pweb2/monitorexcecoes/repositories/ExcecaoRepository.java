package br.edu.ifpb.pweb2.monitorexcecoes.repositories;

import br.edu.ifpb.pweb2.monitorexcecoes.model.Excecao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcecaoRepository extends JpaRepository<Excecao, Long> {
}
