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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserLogicPuzzle(
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
    @Path("/{param}/detail")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDetail(
            @PathParam("param") String userIds) {
        String[] ids = userIds.split(",");
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
        if (userList.size() == 1) {
            result = (Map) userList.get(0);
            return Response.status(Response.Status.OK).entity(result).build();
        }

        result.put("userList", userList);
        return Response.status(Response.Status.OK).entity(result).build();

    }

    @GET
    @Path("/{param}/programs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProgramById(
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserDetail(
            @PathParam("param") int userId,
            UserDetail userDetail
    ) {
        userMapper.updateUserDetail(userDetail);

        Map<String, Object> map = new HashMap<>();
        map.put("uri", "userDetail/" + userDetail.getUserId());

        return Response.status(Response.Status.OK).entity(map).build();
    }


    @GET
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
    @Produces(MediaType.APPLICATION_JSON)
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
    @Path("/password/reset")
    @Produces(MediaType.APPLICATION_JSON)
    public Response resetPassword(Map data) {
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
    public Response searchUsersDetail(
            @DefaultValue("1") @QueryParam("page") Integer page,
            @DefaultValue("15") @QueryParam("pageSize") Integer pageSize,
            @QueryParam("email") String email,
            @QueryParam("privilege") String privilege
    ) {
        Integer pageStart = Math.max(page - 1, 0);
        List<Map> usersDetail = userMapper
                .findUsersByInformation(email, privilege, pageStart * pageSize, pageSize);
        if (usersDetail == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map map = new HashMap<>();
        map.put("usersDetail", usersDetail);

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @POST
    @Path("/user-authority")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUser(Map data) {
        User user = new User();
        user.setEmail((String) data.get("email"));
        user.setMobilePhone((String) data.get("mobilePhone"));
        user.setPassword((String) data.get("password"));
        user.setUserName((String) data.get("userName"));

        ArrayList<Integer> roles = (ArrayList<Integer>) data.get("role");
        if (roles.size() == 0) {
            user.setRole("0");
            userMapper.insertUser(user);
            return Response.status(Response.Status.CREATED).build();
        }

        for (Integer userRole : roles) {
            user.setRole(userRole + "");
            userMapper.insertUser(user);
        }
        return Response.status(Response.Status.CREATED).build();
    }


}
