package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.Stack;
import com.thoughtworks.twars.mapper.StackMapper;
import io.swagger.annotations.Api;


import javax.inject.Inject;
import javax.ws.rs.*;
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
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllStack() {
        List<Stack> stackList = stackMapper.getAllStack();

        Map map = new HashMap<>();
        List<Map> stackListInfo = stackList.stream()
                .map(stack -> stack.toMap())
                .collect(Collectors.toList());
        map.put("items", stackListInfo);

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @Path("/{stackId}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getStackById(
            @PathParam("stackId") int stackId) {
        Stack stack = stackMapper.getStackById(stackId);

        if (stack == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(stack.toMap()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)

    public Response createStack(Stack stack) {
        Stack stack1 = stackMapper.getStackByTitle(stack.getTitle());
        if (stack1 != null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        stackMapper.insertStack(stack);

        Map<String, Object> map = new HashMap<>();

        map.put("stackId", stack.getStackId());
        map.put("uri", "stack/" + stack.getStackId());

        return Response.status(Response.Status.CREATED).entity(map).build();
    }
}
