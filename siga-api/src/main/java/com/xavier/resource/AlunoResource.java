package com.xavier.resource;

import com.xavier.dto.AlunoDTO;
import com.xavier.service.AlunoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

    @Inject
    private AlunoService alunoService;

    @POST
    public Response create(AlunoDTO alunoDTO) {
        AlunoDTO alunoCriado = alunoService.create(alunoDTO);
        return Response.status(Response.Status.CREATED)
                        .entity(alunoCriado)
                        .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(alunoService.findAll())
                        .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, AlunoDTO alunoDTO) {
        return Response.ok(alunoService.update(id, alunoDTO))
                        .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(alunoService.findById(id))
                        .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        alunoService.delete(id);
        return Response.noContent()
                        .build();
    }

    
}
