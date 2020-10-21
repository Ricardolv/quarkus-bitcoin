package br.com.richard.resource.converter;

import br.com.richard.infrastructure.persistence.ordem.Ordem;
import br.com.richard.resource.converter.mapper.OrdemMapper;
import br.com.richard.resource.request.OrdemRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemConverter {

    OrdemMapper ordemMapper;

    public OrdemConverter(OrdemMapper ordemMapper) {
        this.ordemMapper = ordemMapper;
    }

    public Ordem converter(final OrdemRequest ordemRequest) {
        return ordemMapper.toResource(ordemRequest);
    }
}
