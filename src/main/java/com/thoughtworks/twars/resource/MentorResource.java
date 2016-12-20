package com.thoughtworks.twars.resource;


import com.thoughtworks.twars.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/mentors")
@Api
public class MentorResource extends Resource {

    @Inject
    UserMapper userMapper;

    @GET
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "get mentors id by email successfully"),
            @ApiResponse(code = 404, message = "get mentors id by email failure")})
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMentorsIdByEmail(
            @PathParam("email") String email) {

        List<Integer> mentorsId = userMapper.findMentorsIdByEmail(email);

        if (mentorsId == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<String> mentorsUriList = new ArrayList<>();
        for (Integer id : mentorsId) {

            String uri = "users/" + id + "/detail";
            mentorsUriList.add(uri);
        }

        Map map = new HashMap<>();
        map.put("mentorsUri", mentorsUriList);
        return Response.status(Response.Status.OK).entity(map).build();
    }
}
