package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.SingleChoice;
import com.thoughtworks.twars.mapper.SingleChoiceMapper;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/singleChoices")
@Api

public class SingleChoiceResource {

    @Inject
    private SingleChoiceMapper singleChoiceMapper;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertSingleChoice(Map data) {
        SingleChoice singleChoice = new SingleChoice();
        singleChoice.setType((String) data.get("type"));
        singleChoice.setDescription((String) data.get("description"));
        singleChoice.setAnswer((String) data.get("answer"));
        singleChoice.setOptions((String) data.get("options"));

        singleChoiceMapper.insertSingleChoice(singleChoice);

        Map result = new HashMap();
        result.put("uri", "singleChoices/" + singleChoice.getId());

        return Response.status(Response.Status.CREATED).entity(result).build();

    }
}

