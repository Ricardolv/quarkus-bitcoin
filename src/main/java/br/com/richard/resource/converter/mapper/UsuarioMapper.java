package br.com.richard.resource.converter.mapper;

import br.com.richard.application.config.QuarkusMappingConfig;
import br.com.richard.infrastructure.persistence.usuario.Usuario;
import br.com.richard.resource.request.UsuarioRequest;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface UsuarioMapper {

    Usuario toResource(UsuarioRequest usuarioRequest);
}
