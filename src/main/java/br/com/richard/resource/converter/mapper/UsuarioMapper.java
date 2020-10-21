package br.com.richard.resource.converter.mapper;

import br.com.richard.application.config.QuarkusMappingConfig;
import br.com.richard.infrastructure.persistences.usuario.Usuario;
import br.com.richard.resource.request.UsuarioRequest;
import br.com.richard.resource.response.UsuarioResponse;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface UsuarioMapper {

    Usuario toResourceRequest(UsuarioRequest usuarioRequest);
    UsuarioResponse toResourceResponse(Usuario usuario);

}
