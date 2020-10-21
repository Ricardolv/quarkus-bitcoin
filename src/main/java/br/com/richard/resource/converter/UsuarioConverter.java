package br.com.richard.resource.converter;

import br.com.richard.infrastructure.persistences.usuario.Usuario;
import br.com.richard.resource.converter.mapper.UsuarioMapper;
import br.com.richard.resource.request.UsuarioRequest;
import br.com.richard.resource.response.UsuarioResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioConverter {

    UsuarioMapper usuarioMapper;

    public UsuarioConverter(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public Usuario converterRequest(final UsuarioRequest usuarioRequest) {
       return usuarioMapper.toResourceRequest(usuarioRequest);
    }

    public List<UsuarioResponse> converterResponse(List<Usuario> usuarios) {
        return usuarios.parallelStream()
                       .map(usuario -> usuarioMapper.toResourceResponse(usuario))
                       .collect(Collectors.toList());
    }
}
