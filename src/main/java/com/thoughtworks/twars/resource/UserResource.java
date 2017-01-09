package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.*;
import com.thoughtworks.twars.mapper.*;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/users")
@Api
public class UserResource extends Resource {

    @Inject
    private UserMapper userMapper;

    @Inject
    private PasswordRetrieveDetailMapper passwordRetrieveDetailMapper;

    @Inject
    private ScoreSheetMapper scoreSheetMapper;

    @Inject
    private BlankQuizSubmitMapper blankQuizSubmitMapper;

    @Inject
    private ItemPostMapper itemPostMapper;

    @Inject
    private QuizItemMapper quizItemMapper;


    @GET
    @Path("/{param}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one user successful"),
            @ApiResponse(code = 404, message = "get one user failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @ApiParam(name = "userId", value = "int", required = true)
            @PathParam("param") int userId) {

        User user = userMapper.getUserById(userId);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("email", user.getEmail());
        map.put("mobilePhone", user.getMobilePhone());
        map.put("role", user.getRole());

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @Path("/{param}/logicPuzzle")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one user successful"),
            @ApiResponse(code = 404, message = "get one user failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserLogicPuzzle(
            @ApiParam(name = "id", value = "userId", required = true)
            @PathParam("param") int userId) {
        ScoreSheet scoreSheet = scoreSheetMapper.findOneByUserId(userId);

        if (scoreSheet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        BlankQuizSubmit blankQuizSubmit =
                blankQuizSubmitMapper.findByScoreSheetId(scoreSheet.getId()).get(0);

        List<ItemPost> itemPostList = itemPostMapper.findByBlankQuizSubmit(blankQuizSubmit.getId());

        Map map = new HashMap();
        map.put("startTime", blankQuizSubmit.getStartTime());
        map.put("endTime", blankQuizSubmit.getEndTime());
        map.put("itemNumber", itemPostList.size());
        map.put("correctNumber", calculateCorrectNumber(itemPostList));

        return Response.status(Response.Status.OK).entity(map).build();
    }

    public int calculateCorrectNumber(List<ItemPost> itemPostList) {
        List<String> correctList = new ArrayList<>();

        itemPostList.forEach(val -> {
            String answer = quizItemMapper.getQuizItemById(val.getQuizItemId()).getAnswer();
            if (val.getAnswer() != null && val.getAnswer().equals(answer)) {
                correctList.add("true");
            }
        });
        return correctList.size();
    }

    @GET
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one userDetail successful"),
            @ApiResponse(code = 404, message = "get one userDetail user failed")})
    @Path("/{param}/detail")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDetail(
            @ApiParam(name = "userId", value = "String", required = true)
            @PathParam("param") String userIds) {

        String[] ids = userIds.split(",");

        if (ids.length == 1) {
            Integer userId = Integer.parseInt(ids[0]);
            UserDetail detail = userMapper.getUserDetailById(userId);
            User user = userMapper.getUserById(userId);

            if (null == user || null == detail) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Map<String, Object> map = new HashMap<>();
            map.put("userId", detail.getUserId());
            map.put("school", detail.getSchool());
            map.put("major", detail.getMajor());
            map.put("degree", detail.getDegree());
            map.put("name", detail.getName());
            map.put("gender", detail.getGender());
            map.put("email", user.getEmail());
            map.put("mobilePhone", user.getMobilePhone());
            map.put("schoolProvince", detail.getSchoolProvince());
            map.put("schoolCity", detail.getSchoolCity());
            map.put("entranceYear", detail.getEntranceYear());

            return Response.status(Response.Status.OK).entity(map).build();
        }


        List userList = new ArrayList();
        for (String i : ids) {

            Integer userId = Integer.parseInt(i);

            UserDetail detail = userMapper.getUserDetailById(userId);
            User user = userMapper.getUserById(userId);

            if (null == user || null == detail) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Map<String, Object> map = new HashMap<>();
            map.put("userId", detail.getUserId());
            map.put("school", detail.getSchool());
            map.put("major", detail.getMajor());
            map.put("degree", detail.getDegree());
            map.put("name", detail.getName());
            map.put("gender", detail.getGender());
            map.put("email", user.getEmail());
            map.put("mobilePhone", user.getMobilePhone());
            map.put("schoolProvince", detail.getSchoolProvince());
            map.put("schoolCity", detail.getSchoolCity());
            map.put("entranceYear", detail.getEntranceYear());

            userList.add(map);
        }

        Map result = new HashMap<>();
        result.put("userList", userList);
        return Response.status(Response.Status.OK).entity(result).build();


    }

    @GET
    @Path("/{param}/programs")
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "get one user's programIds successful"),
            @ApiResponse(code = 404, message = "get one user's programIds failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProgramById(
            @ApiParam(name = "userId", value = "int", required = true)
            @PathParam("param") int userId) {

        List<Integer> programIds = userMapper.findProgramsById(userId);

        if (programIds == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("programIds", programIds);

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @Path("/{param}/mentors")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get mentorIds successful"),
            @ApiResponse(code = 404, message = "get mentorIds by studentId failure")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMentorIdsByStudentId(
            @PathParam("param") Integer id) {
        List<Integer> mentorIds = userMapper.findMentorIdsByStudentId(id);
        if (mentorIds == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map map = new HashMap<>();
        map.put("mentorIds", mentorIds);

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @Path("/{param}/mentees")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get menteeIds successful"),
            @ApiResponse(code = 404, message = "get menteeIds by mentorId failure")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentIdsByMentorId(
            @PathParam("param") Integer id) {
        List<Integer> studentIds = userMapper.findStudentIdsByMentorId(id);
        if (studentIds == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map map = new HashMap<>();
        map.put("studentIds", studentIds);

        return Response.status(Response.Status.OK).entity(map).build();
    }


    @PUT
    @Path("/{param}/detail")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "update one userDetail successful")})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserDetail(
            @ApiParam(name = "userId", value = "int", required = true)
            @PathParam("param") int userId,
            UserDetail userDetail
    ) {
        userMapper.updateUserDetail(userDetail);

        Map<String, Object> map = new HashMap<>();
        map.put("uri", "userDetail/" + userDetail.getUserId());

        return Response.status(Response.Status.OK).entity(map).build();
    }


    @GET
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "field", value = "field name", required = true),
            @ApiImplicitParam(name = "value", value = "field value", required = true)})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one user successful")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByField(
            @QueryParam("field") String field,
            @QueryParam("value") String value
    ) {
        User user = null;

        if ("email".equals(field)) {
            user = userMapper.getUserByEmail(value);
        } else if ("mobilePhone".equals(field)) {
            user = userMapper.getUserByMobilePhone(value);
        }

        Map<String, String> map = new HashMap<>();

        if (null != user) {

            map.put("uri", "users/" + user.getId());

            return Response.status(Response.Status.OK).entity(map).build();
        }

        map.put("uri", null);

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @PUT
    @Path("/{param}/password")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "userId", value = "int", required = true),
            @ApiImplicitParam(name = "userPasswordMap",
                    value = "include all info when update user password", required = true)})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "update user password successful"),
            @ApiResponse(code = 400, message = "update user password failed")})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserPassword(
            @PathParam("param") int userId,
            Map userPasswordMap
    ) {
        String oldPassword = (String) userPasswordMap.get("oldPassword");
        String password = (String) userPasswordMap.get("password");

        int result = userMapper
                .updatePassword(userId, oldPassword, password);

        if (1 == result) {
            Map<String, Object> map = new HashMap<>();
            map.put("uri", "users/" + userId);

            return Response.status(Response.Status.OK).entity(map).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/password/retrieve")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "field", value = "field name", required = true),
            @ApiImplicitParam(name = "value", value = "field value", required = true)})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one user successful")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUserByField(
            @QueryParam("field") String field,
            @QueryParam("value") String value
    ) {
        User user = userMapper.getUserByEmail(value);
        Map<String, String> map = new HashMap<>();
        String token = null;

        if (null == user) {
            map.put("status", "404");
            map.put("token", token);

            return Response.status(Response.Status.OK).entity(map).build();
        }

        PasswordRetrieveDetail passwordRetrieveDetail =
                passwordRetrieveDetailMapper.getDetailByEmail(value);

        if (passwordRetrieveDetail != null) {
            token = passwordRetrieveDetail.getToken();
            map.put("status", "200");
            map.put("token", token);

            return Response.status(Response.Status.OK).entity(map).build();
        } else {
            passwordRetrieveDetailMapper.updateDetailByEmail(value);
            token = passwordRetrieveDetailMapper.getDetailByEmail(value).getToken();
            map.put("status", "200");
            map.put("token", token);

            return Response.status(Response.Status.OK).entity(map).build();
        }
    }


    @POST
    @ApiResponses(value = {@ApiResponse(code = 201, message = "create user and program's "
            + "relationship successfully"),
            @ApiResponse(code = 403, message = "create user and program's relationship failure")})
    @Path("/{userId}/programs/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response resetPassword(
            @PathParam("userId") Integer userId,
            @PathParam("programId") Integer programId) {

        Integer id = userMapper.insertUserProgram(userId, programId);

        if (id == 0) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        return Response.status(Response.Status.CREATED).build();
    }


    @POST
    @ApiResponses(value = {@ApiResponse(code = 200, message = "reset password successful")})
    @Path("/password/reset")
    @Produces(MediaType.APPLICATION_JSON)
    public Response resetPassword(
            @ApiParam(name = "data", value = "include all info when reset password",
                    required = true)
                    Map data) {
        String newPasword = (String) data.get("newPassword");
        String token = (String) data.get("token");
        int timeLimit = 86400;

        Map map = new HashMap<>();

        PasswordRetrieveDetail passwordRetrieveDetail =
                passwordRetrieveDetailMapper.getDetailByToken(token);

        if (passwordRetrieveDetail == null) {
            map.put("status", "403");
            return Response.status(Response.Status.OK).entity(map).build();
        }

        long timeInterval = Calendar.getInstance().getTimeInMillis() / 1000
                - passwordRetrieveDetail.getRetrieveDate();

        if (timeLimit > timeInterval) {
            User user = new User();
            user.setEmail(passwordRetrieveDetail.getEmail());
            user.setPassword(newPasword);

            userMapper.resetPassword(user);

            passwordRetrieveDetailMapper.setNullToken(user.getEmail());
            map.put("status", "201");
        } else {
            map.put("status", "412");
        }

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "page", value = "page", required = true),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = true)})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get users detail successful"),
            @ApiResponse(code = 404, message = "get users　detail failed")})

    public Response searchUsersDetail(
            @DefaultValue("1") @QueryParam("page") Integer page,
            @DefaultValue("15") @QueryParam("pageSize") Integer pageSize,
            @QueryParam("email") String email,
            @QueryParam("privilege") String privilege
    ) {
        Integer pageStart = Math.max(page - 1, 0);
        List<UserDetail> usersDetail = userMapper
                .findUsersByInformation(email, privilege, pageStart, pageSize);
        if (usersDetail == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map map = new HashMap<>();
        map.put("usersDetail", usersDetail);

        return Response.status(Response.Status.OK).entity(map).build();
    }

}
