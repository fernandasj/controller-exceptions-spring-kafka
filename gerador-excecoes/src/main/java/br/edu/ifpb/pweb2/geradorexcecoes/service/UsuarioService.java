package br.edu.ifpb.pweb2.geradorexcecoes.service;

import br.edu.ifpb.pweb2.geradorexcecoes.commons.Messagem;
import br.edu.ifpb.pweb2.geradorexcecoes.exception.UsuarioException;
import br.edu.ifpb.pweb2.geradorexcecoes.model.Usuario;
import br.edu.ifpb.pweb2.geradorexcecoes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    private UsuarioException exception;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Usuario criarUsuario(Usuario usuario) {

        if (repository.findByLogin(usuario.getLogin()).isPresent()) {
            exception.usuarioNaoEncontradoException(new Messagem(usuario.getLogin(), "Usuario ja existe", "UsuarioService"));
            return null;
        } else if (usuario.getSenha().length() < 6) {
            exception.senhaFracaException(new Messagem(usuario.getLogin(), "Senha Fraca", "UsuarioService"));
            return null;
        }

        usuario.setSenha(encoder.encode(usuario.getSenha()));
        Usuario user = repository.save(usuario);
        if (user == null) {
            exception.falhaInternaException(new Messagem(usuario.getLogin(), "Falha Interna", "UsuarioService"));
            return null;
        }
        return user;
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id).get();
    }

    public void deletarUsuario(Long id) {
        repository.deleteById(id);
    }
}
