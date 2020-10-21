package br.com.richard.domain.usuario;

import br.com.richard.infrastructure.persistence.usuario.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UsuarioService {

    @Transactional
    public void persist(Usuario usuario) {
        Usuario.persist(usuario);
    }
}
