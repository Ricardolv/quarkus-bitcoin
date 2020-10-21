package br.com.richard.domain.usuario;

import br.com.richard.application.config.roles.RoleName;
import br.com.richard.infrastructure.persistences.usuario.Usuario;
import io.quarkus.elytron.security.common.BcryptUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UsuarioService {

    @Transactional
    public void persist(Usuario usuario) {

        usuario.setPassword(BcryptUtil.bcryptHash(usuario.getPassword()));
        usuario.setRole(validarUsername(usuario.getUserName()));
        Usuario.persist(usuario);

    }

    private String validarUsername(String userName) {

        if (userName.equalsIgnoreCase("quarkus")) {
            return RoleName.ADMIN;
        }

        return RoleName.USER;
    }
}
