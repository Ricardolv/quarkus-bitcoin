package br.com.richard.resource.converter.mapper;

import br.com.richard.application.config.QuarkusMappingConfig;
import br.com.richard.infrastructure.persistences.ordem.Ordem;
import br.com.richard.resource.request.OrdemRequest;
import br.com.richard.resource.response.OrdemResponse;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface OrdemMapper {

    Ordem toResourceRequest(OrdemRequest ordemRequest);

    OrdemResponse toResourceResponse(Ordem ordem);
}
