package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.BasicBlankQuiz;
import com.thoughtworks.twars.bean.MultipleChoice;
import com.thoughtworks.twars.bean.SingleChoice;
import com.thoughtworks.twars.mapper.BasicBlankQuizMapper;
import com.thoughtworks.twars.mapper.MultipleChoiceMapper;
import com.thoughtworks.twars.mapper.SingleChoiceMapper;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("/basicBlankQuizzes")
@Api
public class BasicBlankQuizResource {

    @Inject
    private BasicBlankQuizMapper basicBlankQuizMapper;

    @POST
    @Produces(MediaType.APPLICATION_JSON)

    public Response insertBasicQuizzes(Map data) {

        BasicBlankQuiz basicBlankQuiz = new BasicBlankQuiz();
        basicBlankQuiz.setType((String) data.get("type"));
        basicBlankQuiz.setDescription((String) data.get("description"));
        basicBlankQuiz.setAnswer((String) data.get("answer"));

        basicBlankQuizMapper.insertBasicBlankQuiz(basicBlankQuiz);

        Map result = new HashMap();
        result.put("uri", "basicBlankQuizzes/" + basicBlankQuiz.getId());

        return Response.status(Response.Status.CREATED).entity(result).build();

    }
}
