package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.*;
import com.thoughtworks.twars.mapper.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/programs")
@Api
public class ProgramResource extends Resource {

    @Inject
    private PaperMapper paperMapper;
    @Inject
    private PaperOperationMapper paperOperationMapper;
    @Inject
    private SectionMapper sectionMapper;
    @Inject
    private BlankQuizMapper blankQuizMapper;
    @Inject
    private SectionQuizMapper sectionQuizMapper;
    @Inject
    private ProgramMapper programMapper;

    @GET
    @Path("/{programId}/papers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPapersByProgramId(
            @PathParam("programId") int programId) {
        List<Paper> papers = paperMapper.findPapersByProgramId(programId);

        List<Map> items = papers
                .stream()
                .map(item -> item.getPapersInfo())
                .collect(Collectors.toList());

        Map result = new HashMap();

        result.put("paperList", items);

        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Path("/{programId}/papers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPapers(
            @ApiParam(name = "data", value = "insert paper", required = true) Map data,
            @PathParam("programId") int programId) {

        Integer makerId = (Integer) data.get("makerId");
        String paperName = (String) data.get("paperName");
        String description = (String) data.get("description");
        String paperType = (String) data.get("paperType");
        Integer createTime = (Integer) data.get("createTime");

        Paper paper = new Paper();
        paper.setMakerId(makerId);
        paper.setPaperName(paperName);
        paper.setDescription(description);
        paper.setCreateTime(createTime);
        paper.setPaperType(paperType);
        paper.setProgramId(programId);

        paperMapper.insertPaper(paper);

        Integer paperId = paper.getId();

        PaperOperation paperOperation = new PaperOperation();
        paperOperation.setPaperId(paperId);
        paperOperation.setOperatingTime(createTime);
        paperOperation.setOperationType("DISTRIBUTION");
        paperOperation.setOperatorId(makerId);

        paperOperationMapper.insertPaperOperation(paperOperation);

        List sections = (List) data.get("sections");
        for (Object sectionItem : sections) {
            Map section = (Map) sectionItem;
            String sectionDescription = (String) section.get("description");
            String sectionType = (String) section.get("type");

            Section insertSection = new Section();
            insertSection.setPaperId(paperId);
            insertSection.setType(sectionType);
            insertSection.setDescription(sectionDescription);

            sectionMapper.insertSection(insertSection);
            Integer sectionId = insertSection.getId();

            if (sectionType.equals("blankQuizzes")) {
                Map item = (Map) section.get("items");

                Integer easyCount = (Integer) item.get("easyCount");
                Integer normalCount = (Integer) item.get("normalCount");
                Integer hardCount = (Integer) item.get("hardCount");
                Integer exampleCount = (Integer) item.get("exampleCount");

                BlankQuiz insertBlankQuiz = new BlankQuiz();
                insertBlankQuiz.setEasyCount(easyCount);
                insertBlankQuiz.setNormalCount(normalCount);
                insertBlankQuiz.setHardCount(hardCount);
                insertBlankQuiz.setExampleCount(exampleCount);
                insertBlankQuiz.setId(sectionId);

                blankQuizMapper.insertBlankQuiz(insertBlankQuiz);

                Integer blankQuizId = insertBlankQuiz.getId();

                SectionQuiz insertSectionQuiz = new SectionQuiz();
                insertSectionQuiz.setSectionId(sectionId);
                insertSectionQuiz.setQuizId(blankQuizId);

                sectionQuizMapper.insertSectionQuiz(insertSectionQuiz);
            }
            if (sectionType.equals("homeworkQuizzes")) {
                List item = (List) section.get("items");

                for (Object homeworkItem : item) {

                    Map homeworkQuiz = (Map) homeworkItem;

                    Integer homeworkId = (Integer) homeworkQuiz.get("id");

                    SectionQuiz sectionQuiz = new SectionQuiz();
                    sectionQuiz.setQuizId(homeworkId);
                    sectionQuiz.setSectionId(sectionId);

                    sectionQuizMapper.insertSectionQuiz(sectionQuiz);

                }
            }
        }
        Map result = new HashMap();
        result.put("uri", "programs/" + programId + "/papers/" + paperId);

        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @GET
    @Path("/{programId}/papers/{paperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOnePaper(
            @PathParam("programId") int programId,
            @PathParam("paperId") int paperId) {

        Paper paper = paperMapper.getOnePaper(paperId);
        if (paper == null || programId != paper.getProgramId()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK)
                .entity(paper.getResponseInfo()).build();
    }

    @GET
    @Path("/{programId}/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsersIdByProgramId(
            @PathParam("programId") int programId) {
        List<Integer> users = programMapper.findUsersIdByProgramId(programId);
        if (users.size() != 0) {

            List<String> usersUri = new ArrayList<String>();

            for (Integer item : users) {
                String uri = "users/" + item;
                usersUri.add(uri);
            }

            Map<String, Object> result = new HashMap();
            result.put("usersUri", usersUri);

            return Response.status(Response.Status.OK).entity(result).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }


    @POST
    @Path("/{programId}/papers/{paperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPaperOperation(
            @PathParam("programId") int programId,
            @PathParam("paperId") int paperId, Map data) {
        try {

            String operationType = (String) data.get("operation");
            int operatorId = (int) data.get("makerId");
            int operatingTime = (int) data.get("createTime");

            PaperOperation paperOperation = new PaperOperation();
            paperOperation.setOperationType(operationType);
            paperOperation.setOperatorId(operatorId);
            paperOperation.setOperatingTime(operatingTime);
            paperOperation.setPaperId(paperId);

            int result = paperOperationMapper.insertPaperOperation(paperOperation);
            if (result == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPrograms(
            @DefaultValue("1") @QueryParam("page") int page,
            @DefaultValue("15") @QueryParam("pageSize") int pageSize
    ) {

        int startPage = Math.max(page - 1, 0);
        List<Program> programs = programMapper.getAllPrograms(startPage * pageSize, pageSize);
        Map result = new HashMap();

        List<Map> programsInfo = programs.stream()
                .map(program -> program.getResponseInfo())
                .collect(Collectors.toList());

        result.put("programs", programsInfo);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPrograms(Map data) {
        String name = (String) data.get("name");
        Boolean uriEnable = (Boolean) data.get("uriEnable");

        Program program = new Program();
        program.setName(name);
        program.setUriEnable(uriEnable);

        programMapper.insertPrograms(program);

        Map result = new HashMap();
        result.put("id", program.getId());

        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @PUT
    @Path("/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrograms(
            @PathParam("programId") int programId, Map data) {

        Program program = new Program();
        program.setId(programId);
        program.setName((String) data.get("name"));
        program.setUriEnable((Boolean) data.get("uriEnable"));

        programMapper.updatePrograms(program);

        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
