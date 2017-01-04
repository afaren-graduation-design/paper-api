package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.Stack;
import com.thoughtworks.twars.mapper.StackMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Path("/stacks")
@Api
public class StackResource extends Resource {
    @Inject
    private StackMapper stackMapper;

    @GET
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get all stack successful"),
            @ApiResponse(code = 404, message = "get all stack failed")})
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllStack() {
        List<Stack> stackList = stackMapper.getAllStack();

        Map map = new HashMap<>();
        List<Map> stackListInfo = stackList.stream()
                .map(stack -> stack.getResponseInfo())
                .collect(Collectors.toList());
        map.put("items", stackListInfo);

        return Response.status(Response.Status.OK).entity(map).build();
    }
}
