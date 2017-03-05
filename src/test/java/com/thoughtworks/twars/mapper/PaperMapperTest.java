package com.thoughtworks.twars.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.twars.bean.Paper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PaperMapperTest extends TestBase {

    private PaperMapper paperMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        paperMapper = session.getMapper(PaperMapper.class);
    }

    @Test
    public void should_return_all_papers() throws Exception {
        List<Paper> papers = paperMapper.findAll();
        assertThat(papers.size(), is(10));
        assertThat(papers.get(0).getMakerId(), is(1));
    }

    @Test
    public void should_return_paper_with_data() throws Exception {
        Paper paper = paperMapper.getOnePaper(1);
        Gson gson = new GsonBuilder().create();
        final String responseInfoStr = gson.toJson(paper.toMap());

        assertThat(paper.getId(), is(1));
        assertThat(paper.getMakerId(), is(1));
        assertThat(paper.getSections().size(), is(2));

        assertThat(responseInfoStr,
                is("{\"paperName\":\"简单的试卷\","
                        + "\"id\":1,\"sections\":[{\"description\":\"这是描述\","
                        + "\"id\":1,\"quizzes\":[{\"definition_uri\":\"blankQuizzes/1\""
                        + ",\"id\":1,\"items_uri\":\"blankQuizzes/1/items\"},"
                        + "{\"definition_uri\":\"blankQuizzes/2\",\"id\":2,"
                        + "\"items_uri\":\"blankQuizzes/2/items\"}],"
                        + "\"sectionType\":\"blankQuizzes\"},{\"description\":\"这是描述\""
                        + ",\"id\":2,\"quizzes\":"
                        + "[{\"definition_uri\":\"homeworkQuizzes/1\",\"id\":1}"
                        + ",{\"definition_uri\":\"homeworkQuizzes/2\",\"id\":2},"
                        + "{\"definition_uri\":\"homeworkQuizzes/3\",\"id\":3},"
                        + "{\"definition_uri\":\"homeworkQuizzes/4\",\"id\":4},"
                        + "{\"definition_uri\":\"homeworkQuizzes/5\",\"id\":5},"
                        + "{\"definition_uri\":\"homeworkQuizzes/6\",\"id\":6},"
                        + "{\"definition_uri\":\"homeworkQuizzes/7\",\"id\":7},"
                        + "{\"definition_uri\":\"homeworkQuizzes/8\",\"id\":8}]"
                        + ",\"sectionType\":\"homeworkQuizzes\"}]}"));

    }

    @Test
    public void should_insert_paper() {
        Paper paper = new Paper();
        paper.setMakerId(3);
        paper.setPaperName("思沃特训营第一次测验");

        paperMapper.insertPaper(paper);

        assertThat(paper.getId(), is(12));
    }

    @Test
    public void should_return_papers_by_page_and_pageSize() throws Exception {
        List<Paper> papers = paperMapper.getAllPapers(0, 3);
        assertThat(papers.size(), is(2));
        assertThat(papers.get(0).getMakerId(), is(1));
        assertThat(papers.get(1).getMakerId(), is(2));
    }

    @Test
    public void should_return_userCount_by_paperId() throws Exception {
        Map<String, Integer> users = paperMapper.getUserCountByPaperId(1);
        assertThat(users.get("paperId"), is(1));
    }

    @Test
    public void should_get_paper_by_id() throws Exception {
        Paper paper = paperMapper.getPaperById(1);
        assertThat(paper.getMakerId(), is(1));
    }

}