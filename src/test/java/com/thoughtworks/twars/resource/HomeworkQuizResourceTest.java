package com.thoughtworks.twars.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.twars.bean.HomeworkQuiz;
import com.thoughtworks.twars.bean.UserDetail;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeworkQuizResourceTest extends TestBase {
    @Mock
    HomeworkQuiz homeworkQuiz;
    @Mock
    HomeworkQuiz homeworkQuiz01;


    String basePath = "homeworkQuizzes";


    @Test
    public void should_return_one_homework_quiz() {
        when(homeworkQuizMapper.findById(1)).thenReturn(homeworkQuiz);
        when(homeworkQuiz.getMakerId()).thenReturn(1);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");
        when(homeworkQuiz.getAnswerPath()).thenReturn("/homework-answer/check-readme");

        UserDetail userDetail = mock(UserDetail.class);
        when(userDetail.getName()).thenReturn("Rose");
        when(userMapper.getUserDetailById(homeworkQuiz.getMakerId())).thenReturn(userDetail);

        Response response = target(basePath + "/1").request().get();
        assertThat(response.getStatus(), is(200));

        Map homeworkItem = response.readEntity(Map.class);
        Map item = (Map) homeworkItem.get("homeworkItem");
        assertThat(item.get("makerId"), is(1));
        assertThat(item.get("makerName"), is("Rose"));
        assertThat(item.get("description"), is("这是一道比较简单的题目"));
        assertThat(item.get("evaluateScript"), is("www.baidu.com"));
        assertThat(item.get("templateRepository"), is("templateRepository"));
        assertThat(item.get("answerPath"), is("/homework-answer/check-readme"));
    }

    @Test
    public void should_return_homework_quiz_List_by_ids() {
        when(homeworkQuizMapper.findById(1)).thenReturn(homeworkQuiz);

        when(homeworkQuiz.getMakerId()).thenReturn(1);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");
        when(homeworkQuiz.getAnswerPath()).thenReturn("/homework-answer/check-readme");
        when(homeworkQuiz.getStackId()).thenReturn(1);

        when(homeworkQuizMapper.findById(2)).thenReturn(homeworkQuiz01);

        when(homeworkQuiz01.getMakerId()).thenReturn(2);
        when(homeworkQuiz01.getDescription()).thenReturn("这是一道普通难度的题目");
        when(homeworkQuiz01.getEvaluateScript()).thenReturn("www.talkop.com");
        when(homeworkQuiz01.getTemplateRepository()).thenReturn("talkopRepository");
        when(homeworkQuiz01.getAnswerPath()).thenReturn("/homework-answer/calculate_median");
        when(homeworkQuiz01.getStackId()).thenReturn(2);


        UserDetail userDetail = mock(UserDetail.class);
        when(userDetail.getName()).thenReturn("Rose");
        when(userMapper.getUserDetailById(1)).thenReturn(userDetail);
        when(userMapper.getUserDetailById(2)).thenReturn(userDetail);

        Response response = target(basePath + "/1,2").request().get();
        Assert.assertEquals(response.getStatus(), 200);
        assertThat(response.getStatus(), is(200));

        Gson gson = new GsonBuilder().create();
        Map result = response.readEntity(Map.class);
        String jsonStr = gson.toJson(result);
        System.out.println(jsonStr);
        assertThat(jsonStr, is(
                "{\"homeworkQuizzes\":[{\"evaluateScript\":\"www.baidu.com\","
                        + "\"templateRepository\":\"templateRepository\","
                        + "\"createTime\":0,"
                        + "\"stackId\":1,"
                        + "\"description\":\"这是一道比较简单的题目\","
                        + "\"id\":1,"
                        + "\"makerName\":\"Rose\","
                        + "\"answerPath\":\"/homework-answer/check-readme\","
                        + "\"uri\":\"homeworkQuizzes/1\"},"
                        + "{\"evaluateScript\":\"www.talkop.com\","
                        + "\"templateRepository\":\"talkopRepository\","
                        + "\"createTime\":0,"
                        + "\"stackId\":2,"
                        + "\"description\":\"这是一道普通难度的题目\","
                        + "\"id\":2,"
                        + "\"makerName\":\"Rose\","
                        + "\"answerPath\":\"/homework-answer/calculate_median\","
                        + "\"uri\":\"homeworkQuizzes/2\"}]}"
        ));

    }

    @Test
    public void should_return_homework_quiz_by_id() {
        when(homeworkQuizMapper.findById(1)).thenReturn(homeworkQuiz);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");
        when(homeworkQuiz.getAnswerPath()).thenReturn("/homework-answer/check-readme");
        when(homeworkQuiz.getStackId()).thenReturn(1);


        UserDetail userDetail = mock(UserDetail.class);
        when(userDetail.getName()).thenReturn("Rose");
        when(userMapper.getUserDetailById(homeworkQuiz.getMakerId())).thenReturn(userDetail);


        Response response = target("homeworkQuizzes/1").request().get();

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        Map homeworkItem = (Map) result.get("homeworkItem");

        assertThat(homeworkItem.get("id"), is(1));
        assertThat(homeworkItem.get("description"), is("这是一道比较简单的题目"));
        assertThat(homeworkItem.get("evaluateScript"), is("www.baidu.com"));
        assertThat(homeworkItem.get("templateRepository"), is("templateRepository"));
        assertThat(homeworkItem.get("answerPath"), is("/homework-answer/check-readme"));
        assertThat(homeworkItem.get("stackId"), is(1));

    }

    @Test
    public void should_return_all_homework_quiz_List() {
        when(homeworkQuiz.getMakerId()).thenReturn(1);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");
        when(homeworkQuiz.getAnswerPath()).thenReturn("/homework-answer/check-readme");
        when(homeworkQuiz01.getStackId()).thenReturn(1);

        when(homeworkQuiz01.getMakerId()).thenReturn(2);
        when(homeworkQuiz01.getDescription()).thenReturn("这是一道普通难度的题目");
        when(homeworkQuiz01.getEvaluateScript()).thenReturn("www.talkop.com");
        when(homeworkQuiz01.getTemplateRepository()).thenReturn("talkopRepository");
        when(homeworkQuiz01.getAnswerPath()).thenReturn("/homework-answer/check-readme");
        when(homeworkQuiz01.getStackId()).thenReturn(2);


        UserDetail userDetail = mock(UserDetail.class);
        when(userDetail.getName()).thenReturn("Rose");
        when(userMapper.getUserDetailById(1)).thenReturn(userDetail);
        when(userMapper.getUserDetailById(2)).thenReturn(userDetail);

        when(homeworkQuizMapper.findHomeworkQuizzes(null, null, 0, 15))
                .thenReturn(Arrays.asList(homeworkQuiz01, homeworkQuiz));

        Response response = target(basePath).request().get();

        assertThat(response.getStatus(), is(200));

        Gson gson = new GsonBuilder().create();

        Map result = response.readEntity(Map.class);
        String jsonStr = gson.toJson(result);
        assertThat(jsonStr, is("{\"homeworkQuizzes\":[{\"evaluateScript\":\"www.talkop.com\","
                + "\"templateRepository\":\"talkopRepository\",\"createTime\":0,"
                + "\"stackId\":2,"
                + "\"description\":\"这是一道普通难度的题目\","
                + "\"id\":0,"
                + "\"makerName\":\"Rose\","
                + "\"answerPath\":\"/homework-answer/check-readme\","
                + "\"uri\":\"homeworkQuizzes/0\","
                + "\"makerId\":2},"
                + "{\"evaluateScript\":\"www.baidu.com\","
                + "\"templateRepository\":\"templateRepository\","
                + "\"createTime\":0,"
                + "\"stackId\":0,"
                + "\"description\":\"这是一道比较简单的题目\","
                + "\"id\":0,"
                + "\"makerName\":\"Rose\","
                + "\"answerPath\":\"/homework-answer/check-readme\","
                + "\"uri\":\"homeworkQuizzes/0\","
                + "\"makerId\":1}]}"));
    }

    @Test
    public void should_return_homework_quiz_uri() {

        HomeworkQuiz homeworkQuiz = new HomeworkQuiz();

        homeworkQuiz.setDescription("description");
        homeworkQuiz.setEvaluateScript("evaluateScript.sh");
        homeworkQuiz.setTemplateRepository("http://github.com/templateRepository");
        homeworkQuiz.setMakerId(1);
        homeworkQuiz.setHomeworkName("homeworkName");
        homeworkQuiz.setAnswerPath("/homework-answer/calculate_median");

        when(homeworkQuizMapper.insertHomeworkQuiz(homeworkQuiz)).thenReturn(1);

        Map map = new HashMap();

        map.put("description", "miaoshu");
        map.put("evaluateScript", "ceshi ");
        map.put("templateRepository", "http://github.com/templateRepository");
        map.put("makerId", 1);
        map.put("homeworkName", "homeworkName");
        map.put("createTime", 123456);
        map.put("answerPath", "/homework-answer/calculate_median");

        Entity entity = Entity.entity(map, MediaType.APPLICATION_JSON);

        Response response = target(basePath).request().post(entity);

        MatcherAssert.assertThat(response.getStatus(), is(200));
        Map result = response.readEntity(Map.class);

        MatcherAssert.assertThat(result.size(), is(1));
    }
}
