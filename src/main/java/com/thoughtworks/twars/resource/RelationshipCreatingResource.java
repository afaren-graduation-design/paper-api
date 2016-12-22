package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.mapper.UserMapper;
import com.thoughtworks.twars.resource.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/relationshipCreating")
@Api
public class RelationshipCreatingResource extends Resource {
    @Inject
    UserMapper userMapper;

    @POST
    @ApiResponses(value = {@ApiResponse(code = 201,
            message = "create mentor by userId successfully"),
            @ApiResponse(code = 403, message = "create mentor by userId failure")})
    @Path("/{mentorId}/users/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertMentorUser(
            @PathParam("mentorId") int mentorId,
            @PathParam("studentId") int studentId) {

        Integer isCreating = userMapper.insertStudentMentor(mentorId, studentId);
        if (isCreating == 1) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }
}
