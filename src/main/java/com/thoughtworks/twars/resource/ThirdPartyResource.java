package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.ThirdParty;
import com.thoughtworks.twars.mapper.ThirdPartyMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/auth/thirdParty")

public class ThirdPartyResource extends  Resource{
    @Inject
    private ThirdPartyMapper thirdPartyMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/github")
    public Response createUser(ThirdParty thirdParty) {
        thirdParty.setType("github");
        thirdPartyMapper.insertThirdPartyUser(thirdParty);
        Map result = new HashMap<>();
        result.put("userId", thirdParty.getUserId());

        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @GET
    @Path("/github")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findThirdPartyUserById(@QueryParam("thirdPartyUserId") int thirdPartyUserId) {
        ThirdParty thirdParty = new ThirdParty();
        thirdParty.setType("github");
        thirdParty.setThirdPartyUserId(thirdPartyUserId);
        ThirdParty result = thirdPartyMapper.getByThirdPartyUserIdAndType(thirdParty);

        if(result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return  Response.status(Response.Status.OK).entity(thirdParty).build();
    }
}
