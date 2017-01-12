package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.HomeworkQuiz;
import com.thoughtworks.twars.mapper.HomeworkQuizMapper;
import com.thoughtworks.twars.mapper.UserMapper;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/homeworkQuizzes")
@Api
public class HomeworkQuizResource extends Resource {
    @Inject
    private HomeworkQuizMapper homeworkQuizMapper;

    @Inject
    private UserMapper userMapper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHomeworkQuiz(
            @DefaultValue("1") @QueryParam("page") int page,
            @DefaultValue("15") @QueryParam("pageSize") int pageSize,
            @QueryParam("homeworkName") String homeworkName,
            @QueryParam("stackId") Integer stackId
    ) {
        int startPage = Math.max(page - 1, 0);
        List<HomeworkQuiz> allHomeworkQuizzes = homeworkQuizMapper
                .findHomeworkQuizzes(homeworkName, stackId, startPage * pageSize, pageSize);
        List<Map> items = allHomeworkQuizzes
                .stream()
                .map(item -> item.getResponseInfo())
                .collect(Collectors.toList());
        Map result = new HashMap<>();
        result.put("homeworkQuizzes", items);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOneHomeworkQuiz(
            @PathParam("param") String ids) {
        List homeworkQuizzes = new ArrayList();
        String[] idList = ids.split(",");

        for (String i : idList) {
            Integer id = Integer.parseInt(i);
            HomeworkQuiz homeworkQuiz = homeworkQuizMapper.findById(id);

            Map homeworkItem = homeworkQuiz.getResponseInfo();

            homeworkQuizzes.add(homeworkItem);
        }

        Map result = new HashMap<>();
        if (homeworkQuizzes.size() == 1) {
            result = (Map) homeworkQuizzes.get(0);
            return Response.status(Response.Status.OK).entity(result).build();
        }
        result.put("homeworkQuizzes", homeworkQuizzes);

        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPaper(Map data) {
        try {
            HomeworkQuiz homeworkQuiz = new HomeworkQuiz();
            String description = (String) data.get("description");
            homeworkQuiz.setDescription(description);
            String evaluateScript = (String) data.get("evaluateScript");
            homeworkQuiz.setEvaluateScript(evaluateScript);
            String templateRepository = (String) data.get("templateRepository");
            homeworkQuiz.setTemplateRepository(templateRepository);
            int makerId = (int) data.get("makerId");
            homeworkQuiz.setMakerId(makerId);
            String homeworkName = (String) data.get("homeworkName");
            homeworkQuiz.setHomeworkName(homeworkName);
            double createTime = (double) data.get("createTime");
            homeworkQuiz.setCreateTime(createTime);

            String answerPath = (String) data.get("answerPath");
            homeworkQuiz.setAnswerPath(answerPath);

            int stackId = 1;
            if (data.get("stackId") != null) {
                stackId = (int) data.get("stackId");
            }
            homeworkQuiz.setStackId(stackId);

            homeworkQuizMapper.insertHomeworkQuiz(homeworkQuiz);
            Integer id = homeworkQuiz.getId();

            Map map = new HashMap();
            map.put("uri", "homeworkQuizzes/" + id);

            return Response.status(Response.Status.OK).entity(map).build();
        } catch (Exception exception) {
            session.rollback();
        }
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).build();
    }

}
