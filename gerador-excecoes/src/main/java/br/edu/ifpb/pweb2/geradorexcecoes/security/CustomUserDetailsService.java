package br.edu.ifpb.pweb2.geradorexcecoes.security;

import br.edu.ifpb.pweb2.geradorexcecoes.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UsuarioRepository repository;

    public CustomUserDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        return this.repository.findByLogin(usuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário com login: " + usuario + " não foi encontrado"));
    }

}

