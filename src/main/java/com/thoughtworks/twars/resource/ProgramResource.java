package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.*;
import com.thoughtworks.twars.mapper.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GET
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "get paper list by program id successfully"),
            @ApiResponse(code = 404, message = "get paper list by program id failed")})
    @Path("/{programId}/papers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPapersByProgramId(
            @ApiParam(name = "programId", value = "programId", required = true)
            @PathParam("programId") int programId) {
        List<Paper> papers = paperMapper.findPapersByProgramId(programId);

        if (papers == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<Map> paperList = new ArrayList<>();

        for (Paper paper : papers) {

            Map paperItem = new HashMap();
            paperItem.put("id", paper.getId());
            paperItem.put("makerId", paper.getMakerId());
            paperItem.put("description", paper.getDescription());
            paperItem.put("paperName", paper.getPaperName());
            paperItem.put("createTime", paper.getCreateTime());
            paperItem.put("isDistribution", paper.getIsDistribution());
            paperItem.put("programId", paper.getProgramId());
            paperItem.put("uri", "/papers/" + paper.getId());

            paperList.add(paperItem);
        }

        Map result = new HashMap();
        result.put("paperList", paperList);

        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @ApiResponses(value = {@ApiResponse(code = 201,
            message = "create paper list by programId successfully"),
            @ApiResponse(code = 415, message = "create paper list by program id failed")})
    @Path("/{programId}/papers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPapers(
            @ApiParam(name = "data", value = "include all info when insert paper", required = true) Map data,
            @PathParam("programId") int programId) {

        Integer makerId = (Integer) data.get("makerId");
        String paperName = (String) data.get("paperName");
        String description = (String) data.get("description");
        Integer createTime = (Integer) data.get("createTime");
        Boolean isDistribution = true;

        Paper paper = new Paper();
        paper.setMakerId(makerId);
        paper.setPaperName(paperName);
        paper.setDescription(description);
        paper.setCreateTime(createTime);
        paper.setIsDistribution(isDistribution);

        paperMapper.insertPaper(paper);

        Integer paperId = paper.getId();

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
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "get one paper from program successfully"),
            @ApiResponse(code = 404, message = "get one paper from program failed")})
    @Path("/{programId}/paper/{paperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOnePaper(
            @ApiParam(name = "programId", value = "programId", required = true)
            @PathParam("programId") int programId,
            @ApiParam(name = "paperId", value = "paperId", required = true)
            @PathParam("paperId") int paperId) {

        Paper paper = paperMapper.getOnePaper(paperId);
        if (paper == null || programId != paper.getProgramId()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK)
                .entity(paper.getResponseInfo()).build();
    }

    @POST
    @ApiResponses(value = {@ApiResponse(code = 204, message = "delete paper successfully"),
            @ApiResponse(code = 404, message = "delete paper failed")})
    @Path("/{programId}/paper/{paperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPaperOperation(
            @ApiParam(name = "programId", value = "programId", required = true)
            @PathParam("programId") int programId,
            @ApiParam(name = "paperId", value = "paperId", required = true)
            @PathParam("paperId") int paperId,
            @ApiParam(name = "data",
                    value = "include all info about paper operation when delete paper",
                    required = true)
                    Map data) {
        try {

            String operationType = (String) data.get("operationType");
            int operatorId = (int) data.get("operatorId");
            int operatingTime = (int) data.get("operatingTime");

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
}
