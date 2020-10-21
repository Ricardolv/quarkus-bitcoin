package br.com.richard.resource;

import br.com.richard.domain.ordem.OrdemService;
import br.com.richard.resource.converter.OrdemConverter;
import br.com.richard.resource.request.OrdemRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/ordens")
public class OrdemResource {

    OrdemService ordemService;
    OrdemConverter ordemConverter;

    public OrdemResource(OrdemService ordemService, OrdemConverter ordemConverter) {
        this.ordemService = ordemService;
        this.ordemConverter = ordemConverter;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(OrdemRequest ordemRequest) {
        ordemService.insert(ordemConverter.converter(ordemRequest));
    }
}
