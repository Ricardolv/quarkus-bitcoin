package br.com.richard.resource;

import br.com.richard.application.config.roles.RoleName;
import br.com.richard.domain.ordem.OrdemService;
import br.com.richard.resource.converter.OrdemConverter;
import br.com.richard.resource.request.OrdemRequest;
import br.com.richard.resource.response.OrdemResponse;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

import static br.com.richard.application.config.roles.RoleName.ADMIN;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

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
        ordemService.inserir(securityContext, ordemConverter.converterRequest(ordemRequest));
    }

    @GET
    @Produces(APPLICATION_JSON)
    @RolesAllowed(ADMIN)
    public List<OrdemResponse> listar() {
        return ordemConverter.converterResponse(ordemService.listar());
    }

}
