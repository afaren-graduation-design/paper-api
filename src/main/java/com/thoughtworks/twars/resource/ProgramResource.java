package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.Paper;
import com.thoughtworks.twars.bean.PaperOperation;
import com.thoughtworks.twars.mapper.PaperMapper;
import com.thoughtworks.twars.mapper.PaperOperationMapper;
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
            paperItem.put("id",paper.getId());
            paperItem.put("makerId",paper.getMakerId());
            paperItem.put("description",paper.getDescription());
            paperItem.put("paperName",paper.getPaperName());
            paperItem.put("createTime",paper.getCreateTime());
            paperItem.put("isDistribution",paper.getIsDistribution());
            paperItem.put("programId",paper.getProgramId());
            paperItem.put("uri","/papers/"+paper.getId());

            paperList.add(paperItem);
        }

        Map result = new HashMap();
        result.put("paperList" ,paperList);

        return Response.status(Response.Status.OK).entity(result).build();
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
                .entity(paper).build();
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
