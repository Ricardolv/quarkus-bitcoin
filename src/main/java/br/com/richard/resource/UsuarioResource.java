package br.com.richard.resource;

import br.com.richard.domain.usuario.UsuarioService;
import br.com.richard.infrastructure.persistences.usuario.Usuario;
import br.com.richard.resource.converter.UsuarioConverter;
import br.com.richard.resource.request.UsuarioRequest;
import br.com.richard.resource.response.UsuarioResponse;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import java.util.List;

import static br.com.richard.application.config.roles.RoleName.ADMIN;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/usuarios")
public class UsuarioResource {

    UsuarioService usuarioService;
    UsuarioConverter usuarioConverter;

    public UsuarioResource(UsuarioService usuarioService, UsuarioConverter usuarioConverter) {
        this.usuarioService = usuarioService;
        this.usuarioConverter = usuarioConverter;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @PermitAll
    public void inserir(UsuarioRequest usuarioRequest) {

        Usuario usuario = usuarioConverter.converterRequest(usuarioRequest);
        usuarioService.persist(usuario);
    }

    @GET
    @Produces(APPLICATION_JSON)
    @RolesAllowed(ADMIN)
    public List<UsuarioResponse> listar() {
        return usuarioConverter.converterResponse(usuarioService.listar());
    }
}
