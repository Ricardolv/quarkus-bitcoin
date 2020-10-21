package br.com.richard.resource;

import br.com.richard.domain.usuario.UsuarioService;
import br.com.richard.infrastructure.persistences.usuario.Usuario;
import br.com.richard.resource.converter.UsuarioConverter;
import br.com.richard.resource.request.UsuarioRequest;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    UsuarioService usuarioService;
    UsuarioConverter usuarioConverter;

    public UsuarioResource(UsuarioService usuarioService, UsuarioConverter usuarioConverter) {
        this.usuarioService = usuarioService;
        this.usuarioConverter = usuarioConverter;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public void inserir(UsuarioRequest usuarioRequest) {

        Usuario usuario = usuarioConverter.converter(usuarioRequest);
        usuarioService.persist(usuario);
    }
}
