package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.HomeworkQuiz;
import com.thoughtworks.twars.bean.UserDetail;
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
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "page", value = "page"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful"),
            @ApiResponse(code = 404, message = "not found")})
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
            UserDetail userDetail = userMapper.getUserDetailById(homeworkQuiz.getMakerId());
            homeworkItem.put("makerId", homeworkQuiz.getMakerId());
            homeworkItem.put("makerName", userDetail.getName());
            homeworkItem.put("createTime", homeworkQuiz.getCreateTime());
            homeworkItem.put("homeworkName", homeworkQuiz.getHomeworkName());
            homeworkItem.put("type", homeworkQuiz.getType());
            homeworkItem.put("answerPath", homeworkQuiz.getAnswerPath());
            homeworkItem.put("uri", "homeworkQuizzes/" + homeworkQuiz.getId());

            homeworkQuizzes.add(homeworkItem);

        }

        Map result = new HashMap<>();
        result.put("homeworkQuizzes", homeworkQuizzes);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @GET
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful"),
            @ApiResponse(code = 404, message = "not found")})
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOneHomeworkQuiz(
            @ApiParam(value = "homeworkQuizIds", allowableValues = "string", required = true)
            @PathParam("param") String ids) {
        List homeworkQuizzes = new ArrayList();
        String[] idList = ids.split(",");

        if (idList.length == 1) {
            Integer id = Integer.parseInt(idList[0]);
            HomeworkQuiz homeworkQuiz = homeworkQuizMapper.findById(id);

            if (homeworkQuiz == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Map homeworkItem = new HashMap<>();

            homeworkItem.put("id", id);
            homeworkItem.put("description", homeworkQuiz.getDescription());
            homeworkItem.put("evaluateScript", homeworkQuiz.getEvaluateScript());
            homeworkItem.put("templateRepository", homeworkQuiz.getTemplateRepository());
            homeworkItem.put("makerId", homeworkQuiz.getMakerId());
            UserDetail userDetail = userMapper.getUserDetailById(homeworkQuiz.getMakerId());
            homeworkItem.put("makerName", userDetail.getName());
            homeworkItem.put("createTime", homeworkQuiz.getCreateTime());
            homeworkItem.put("homeworkName", homeworkQuiz.getHomeworkName());
            homeworkItem.put("type", homeworkQuiz.getType());
            homeworkItem.put("answerPath", homeworkQuiz.getAnswerPath());
            homeworkItem.put("uri", "homeworkQuizzes/" + id);

            Map result = new HashMap<>();
            result.put("homeworkItem", homeworkItem);
            return Response.status(Response.Status.OK).entity(result).build();

        }

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
            UserDetail userDetail = userMapper.getUserDetailById(homeworkQuiz.getMakerId());
            homeworkItem.put("makerName", userDetail.getName());
            homeworkItem.put("createTime", homeworkQuiz.getCreateTime());
            homeworkItem.put("homeworkName", homeworkQuiz.getHomeworkName());
            homeworkItem.put("uri", "homeworkQuizzes/" + id);
            homeworkItem.put("type", homeworkQuiz.getType());


            homeworkQuizzes.add(homeworkItem);
        }
        Map result = new HashMap<>();
        result.put("homeworkQuizzes", homeworkQuizzes);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @ApiResponses(value = {@ApiResponse(code = 200, message = "insert successfully"),
            @ApiResponse(code = 415, message = "insert failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPaper(
            @ApiParam(name = "data", value = "all info one homework quiz ", required = true)
                    Map data) {
        try {
            HomeworkQuiz homeworkQuiz = new HomeworkQuiz();

            String description = (String) data.get("description");
            String evaluateScript = (String) data.get("evaluateScript");
            String templateRepository = (String) data.get("templateRepository");
            int makerId = (int) data.get("makerId");
            String homeworkName = (String) data.get("homeworkName");
            int createTime = (int) data.get("createTime");
            String type = (String) data.get("type");
            String answerPath = (String) data.get("answerPath");


            homeworkQuiz.setDescription(description);
            homeworkQuiz.setEvaluateScript(evaluateScript);
            homeworkQuiz.setTemplateRepository(templateRepository);
            homeworkQuiz.setMakerId(makerId);
            homeworkQuiz.setHomeworkName(homeworkName);
            homeworkQuiz.setCreateTime(createTime);
            homeworkQuiz.setType(type);
            homeworkQuiz.setAnswerPath(answerPath);

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
