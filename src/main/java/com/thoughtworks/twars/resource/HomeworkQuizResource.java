package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.HomeworkQuiz;
import com.thoughtworks.twars.bean.UserDetail;
import com.thoughtworks.twars.mapper.HomeworkQuizMapper;
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


@Path("/homeworkQuizzes")
@Api
public class HomeworkQuizResource {
    @Inject
    private HomeworkQuizMapper homeworkQuizMapper;

    @Inject
    private UserMapper userMapper;


    @GET
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful"),
            @ApiResponse(code = 404, message = "not found")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHomeworkQuiz() {
        List<HomeworkQuiz> homeworkQuizzes = homeworkQuizMapper.findAllHomeworkQuizzes();

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
            homeworkItem.put("homeworkName", homeworkQuiz.getCreateTime());

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
            homeworkItem.put("homeworkName", homeworkQuiz.getCreateTime());

            homeworkQuizzes.add(homeworkItem);
        }
        Map result = new HashMap<>();
        result.put("homeworkQuizzes", homeworkQuizzes);
        return Response.status(Response.Status.OK).entity(result).build();
    }
}
