package br.com.richard.resource.converter;

import br.com.richard.infrastructure.persistences.ordem.Ordem;
import br.com.richard.resource.converter.mapper.OrdemMapper;
import br.com.richard.resource.request.OrdemRequest;
import br.com.richard.resource.response.OrdemResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrdemConverter {

    OrdemMapper ordemMapper;

    public OrdemConverter(OrdemMapper ordemMapper) {
        this.ordemMapper = ordemMapper;
    }

    public Ordem converterRequest(final OrdemRequest ordemRequest) {
        return ordemMapper.toResourceRequest(ordemRequest);
    }

    public List<OrdemResponse> converterResponse(List<Ordem> ordens) {
        return ordens.parallelStream()
                     .map(ordem -> ordemMapper.toResourceResponse(ordem))
                     .collect(Collectors.toList());
    }
}
