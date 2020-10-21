package br.com.richard.resource;

import br.com.richard.application.config.roles.RoleName;
import br.com.richard.domain.ordem.OrdemService;
import br.com.richard.resource.converter.OrdemConverter;
import br.com.richard.resource.request.OrdemRequest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

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
    @RolesAllowed(RoleName.USER)
    public void inserir(@Context SecurityContext securityContext, OrdemRequest ordemRequest) {
        ordemService.inserir(securityContext, ordemConverter.converter(ordemRequest));
    }

}
