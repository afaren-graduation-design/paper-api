package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.mapper.ProgramMapper;
import com.thoughtworks.twars.mapper.ReportsMapper;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/reports")
public class ReportsResource {

    @Inject
    private ReportsMapper reportsMapper;
    
    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPapersByProgramId(@PathParam("type") Integer type,
                                            @QueryParam("data") String data) {

        Map sqlString = new HashMap();
        sqlString.put(1, "select p.*, count(*) AS examerCount from paper p,scoreSheet s where p.programId =#{programId} and p.id = s.paperId group by p.id;");

        Gson gson = new Gson();
        Map map = gson.fromJson(data, java.util.Map.class);
        map.put("sql", sqlString.get(type));

        List<Map> itemList = reportsMapper.selectData(map);

        Map result = new HashMap();
        result.put("items", itemList);

        return Response.status(Response.Status.OK).entity(result).build();

    }
}

