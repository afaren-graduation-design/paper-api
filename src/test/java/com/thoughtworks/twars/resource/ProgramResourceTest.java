package com.thoughtworks.twars.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.twars.bean.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.*;

import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class ProgramResourceTest extends TestBase {
    String basePath = "/programs";

    @Mock
    Paper paper;

    @Mock
    List<Paper> papers;

    @Mock
    Paper firstPaper;

    @Mock
    Paper secondPaper;


    @Test
    public void should_list_all_papers() throws Exception {

        when(paperMapper.getOnePaper(2)).thenReturn(paper);

        when(paper.getProgramId()).thenReturn(1);

        Section section1 = new Section();
        section1.setId(1);
        section1.setDescription("just a test");
        section1.setType("blankQuizzes");

        List<Section> sections = new ArrayList();

        sections.add(section1);

        Section section2 = new Section();
        section2.setId(2);
        section2.setDescription("just a test 2");
        section2.setType("homeworkQuizzes");

        sections.add(section2);

        when(paper.getSections()).thenReturn(sections);

        Response response = target(basePath + "/1/paper/2").request().get();

        assertThat(response.getStatus(), is(200));

    }

    @Test
    public void should_list_all_papers_by_programId() throws Exception {

        when(paperMapper.findPapersByProgramId(6)).thenReturn(Arrays.asList(firstPaper, secondPaper));
        when(papers.size()).thenReturn(2);

        when(firstPaper.getId()).thenReturn(1);
        when(firstPaper.getPaperName()).thenReturn("简单的试卷");
        when(firstPaper.getDescription()).thenReturn("easy");
        when(firstPaper.getCreateTime()).thenReturn(1111111);
        when(firstPaper.getMakerId()).thenReturn(3);
        when(firstPaper.getIsDistribution()).thenReturn(true);

        when(secondPaper.getId()).thenReturn(5);
        when(secondPaper.getPaperName()).thenReturn("普通的试卷");
        when(secondPaper.getDescription()).thenReturn("common");
        when(secondPaper.getCreateTime()).thenReturn(2222222);
        when(secondPaper.getMakerId()).thenReturn(2);
        when(secondPaper.getIsDistribution()).thenReturn(false);

        Response response = target(basePath+"/6/papers").request().get();
        Assert.assertThat(response.getStatus(), is(200));

        Gson gson = new GsonBuilder().create();

        Map result = response.readEntity(Map.class);
        String jsonStr = gson.toJson(result);

        Assert.assertThat(jsonStr, is("{\"paperList\":[{\"createTime\":\"2016-11-11\",\"paperName\":\"简单的试卷\",\"description\":\"easy\",\"isDistribution\":true,\"id\":1,\"uri\":\"/papers/1\",\"programId\":0,\"makerId\":3},{\"createTime\":\"2016-11-12\",\"paperName\":\"普通的试卷\",\"description\":\"common\",\"isDistribution\":false,\"id\":5,\"uri\":\"/papers/5\",\"programId\":0,\"makerId\":2}]}"));
    }
}
