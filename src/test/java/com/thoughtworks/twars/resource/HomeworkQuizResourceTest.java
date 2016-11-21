package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.HomeworkQuiz;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeworkQuizResourceTest extends TestBase {
    @Mock
    HomeworkQuiz homeworkQuiz;

    @Mock
    HomeworkQuiz homeworkQuiz01;

    String basePath = "/homeworkQuizzes";

    @Test
    public void should_return_one_homework_quiz() {
        when(homeworkQuizMapper.findById(1)).thenReturn(homeworkQuiz);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");

        Response response = target(basePath + "/1").request().get();
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void should_return_homework_quiz_List_by_ids() {
        when(homeworkQuizMapper.findById(1)).thenReturn(homeworkQuiz);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");

        when(homeworkQuizMapper.findById(2)).thenReturn(homeworkQuiz01);
        when(homeworkQuiz01.getDescription()).thenReturn("这是一道普通难度的题目");
        when(homeworkQuiz01.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz01.getTemplateRepository()).thenReturn("templateRepository");

        Response response = target(basePath + "/1,2").request().get();

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        List<Map> homeworkQuizzes = (List) result.get("homeworkQuizzes");
        assertThat(homeworkQuizzes.size(), is(2));

        Map homeworkItem_01 = homeworkQuizzes.get(0);
        Map homeworkItem_02 = homeworkQuizzes.get(1);

        Assert.assertThat(homeworkQuizzes.size(), is(2));

        Assert.assertThat(homeworkItem_01.get("id"), is(1));
        Assert.assertThat(homeworkItem_01.get("description"), is("这是一道比较简单的题目"));
        Assert.assertThat(homeworkItem_01.get("evaluateScript"), is("www.baidu.com"));
        Assert.assertThat(homeworkItem_01.get("templateRepository"), is("templateRepository"));

        Assert.assertThat(homeworkItem_02.get("id"), is(2));
        Assert.assertThat(homeworkItem_02.get("description"), is("这是一道普通难度的题目"));
        Assert.assertThat(homeworkItem_02.get("evaluateScript"), is("www.baidu.com"));
        Assert.assertThat(homeworkItem_02.get("templateRepository"), is("templateRepository"));

    }
}