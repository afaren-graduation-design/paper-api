package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.*;
import com.thoughtworks.twars.mapper.*;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/program")
@Api
public class ProgramResource extends Resource {

    @Inject
    private PaperMapper paperMapper;

    @GET
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one paper from program successfully"),
            @ApiResponse(code = 404, message = "get one paper from program failed")})
    @Path("/{programId}/paper/{paperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOnePaper(
            @ApiParam(name = "programId", value = "programId", required = true)
            @PathParam("programId") int programId,
            @ApiParam(name = "paperId", value = "paperId", required = true)
            @PathParam("paperId") int paperId) {

        Paper paper = paperMapper.getOnePaper(paperId);
        if (paper == null || programId != paper.getProgramId()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK)
                .entity(paper.getResponseInfo()).build();
    }
}
