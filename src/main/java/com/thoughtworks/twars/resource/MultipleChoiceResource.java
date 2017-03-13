package com.thoughtworks.twars.resource;


import com.thoughtworks.twars.bean.MultipleChoice;
import com.thoughtworks.twars.mapper.MultipleChoiceMapper;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;


@Path("/multipleChoices")
@Api

public class MultipleChoiceResource {

    @Inject
    private MultipleChoiceMapper multipleChoiceMapper;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertMultipleChoice(Map data) {

        MultipleChoice multipleChoice = new MultipleChoice();
        multipleChoice.setType((String) data.get("type"));
        multipleChoice.setDescription((String) data.get("description"));
        multipleChoice.setAnswer((String) data.get("answer"));
        multipleChoice.setOptions((String) data.get("options"));

        multipleChoiceMapper.insertMultipleChoice(multipleChoice);

        Map result = new HashMap();
        result.put("uri", "multipleChoices/" + multipleChoice.getId());

        return Response.status(Response.Status.CREATED).entity(result).build();

    }
}
