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
            @QueryParam("type") String type
    ) {
        int startPage = Math.max(page - 1, 0);
        List<HomeworkQuiz> allHomeworkQuizzes = homeworkQuizMapper
                .findHomeworkQuizzes(homeworkName, type, startPage, pageSize);
        List homeworkQuizzes = new ArrayList();

        for (HomeworkQuiz homeworkQuiz : allHomeworkQuizzes) {
            Map homeworkItem = new HashMap<>();

            homeworkItem.put("id", homeworkQuiz.getId());
            homeworkItem.put("description", homeworkQuiz.getDescription());
            homeworkItem.put("evaluateScript", homeworkQuiz.getEvaluateScript());
            homeworkItem.put("templateRepository", homeworkQuiz.getTemplateRepository());
            homeworkItem.put("makerId", homeworkQuiz.getMakerId());
            homeworkItem.put("makerDetailUri", "users/" + homeworkQuiz.getMakerId() + "/detail");
            homeworkItem.put("createTime", homeworkQuiz.getCreateTime());
            homeworkItem.put("homeworkName", homeworkQuiz.getHomeworkName());
            homeworkItem.put("type", homeworkQuiz.getType());
            homeworkItem.put("answerPath", homeworkQuiz.getAnswerPath());
            homeworkItem.put("stackId", homeworkQuiz.getStackId());
            homeworkItem.put("uri", "homeworkQuizzes/" + homeworkQuiz.getId());

            homeworkQuizzes.add(homeworkItem);

        }

        Map result = new HashMap<>();
        result.put("homeworkQuizzes", homeworkQuizzes);
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

            if (homeworkQuiz == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Map homeworkItem = new HashMap<>();

            homeworkItem.put("id", id);
            homeworkItem.put("description", homeworkQuiz.getDescription());
            homeworkItem.put("evaluateScript", homeworkQuiz.getEvaluateScript());
            homeworkItem.put("templateRepository", homeworkQuiz.getTemplateRepository());
            homeworkItem.put("makerDetailUri", "users/" + homeworkQuiz.getMakerId() + "/detail");
            homeworkItem.put("makerId", homeworkQuiz.getMakerId());
            homeworkItem.put("createTime", homeworkQuiz.getCreateTime());
            homeworkItem.put("homeworkName", homeworkQuiz.getHomeworkName());
            homeworkItem.put("answerPath", homeworkQuiz.getAnswerPath());
            homeworkItem.put("stackId", homeworkQuiz.getStackId());
            homeworkItem.put("uri", "homeworkQuizzes/" + id);
            homeworkItem.put("type", homeworkQuiz.getType());

            homeworkQuizzes.add(homeworkItem);
        }
        Map result = new HashMap<>();
        if(homeworkQuizzes.size() == 1) {
            result = (Map) homeworkQuizzes.get(0);
        }else{
            result.put("homeworkQuizzes", homeworkQuizzes);
        }
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
            String type = (String) data.get("type");
            homeworkQuiz.setType(type);
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
