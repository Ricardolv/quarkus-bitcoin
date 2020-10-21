package br.com.richard.resource;

import br.com.richard.domain.usuario.Usuario;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void inserir(Usuario usuario) {
        Usuario.persist(usuario);
    }
}
