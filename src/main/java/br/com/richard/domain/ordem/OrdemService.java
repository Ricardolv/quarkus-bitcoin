package br.com.richard.domain.ordem;

import br.com.richard.infrastructure.persistences.ordem.Ordem;
import br.com.richard.infrastructure.persistences.ordem.OrdemRepository;
import br.com.richard.infrastructure.persistences.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional
    public void inserir(SecurityContext securityContext, Ordem ordem) {

        validarUsuarioLogado(securityContext.getUserPrincipal().getName(), ordem.getUserId());

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);

    }

    private void validarUsuarioLogado(String UserPrincipalName, Long userId) {
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(userId);
        Usuario usuario = usuarioOptional.orElseThrow();

        if (!usuario.getUserName().equals(UserPrincipalName)) {
            throw new RuntimeException("Usuario logado e diferente do userId");
        }
    }

}
