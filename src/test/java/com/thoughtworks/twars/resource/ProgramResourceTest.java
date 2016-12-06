package com.thoughtworks.twars.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.twars.bean.*;
import com.thoughtworks.twars.mapper.PaperMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.*;

import static org.mockito.Mockito.when;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProgramResourceTest extends TestBase {
    String basePath = "/program";

    @Mock
    Paper paper;
    
    @Test
    public void should_list_all_papers_by_page_and_pageSize() throws Exception {

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

        Paper onePaper = response.readEntity(Paper.class);

        assertThat(response.getStatus(), is(200));

    }
}
