package br.com.richard.resource.converter;

import br.com.richard.infrastructure.persistences.usuario.Usuario;
import br.com.richard.resource.converter.mapper.UsuarioMapper;
import br.com.richard.resource.request.UsuarioRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioConverter {

    UsuarioMapper usuarioMapper;

    public UsuarioConverter(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public Usuario converter(final UsuarioRequest usuarioRequest) {
       return usuarioMapper.toResource(usuarioRequest);
    }
}
