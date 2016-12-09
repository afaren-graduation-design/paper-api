package com.thoughtworks.twars.resource;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    }

    @Test
    public void should_return_homework_quiz_List_by_ids() {
        when(homeworkQuizMapper.findById(1)).thenReturn(homeworkQuiz);

        when(homeworkQuiz.getMakerId()).thenReturn(1);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");


        when(homeworkQuizMapper.findById(2)).thenReturn(homeworkQuiz01);

        when(homeworkQuiz01.getMakerId()).thenReturn(2);
        when(homeworkQuiz01.getDescription()).thenReturn("这是一道普通难度的题目");
        when(homeworkQuiz01.getEvaluateScript()).thenReturn("www.talkop.com");
        when(homeworkQuiz01.getTemplateRepository()).thenReturn("talkopRepository");


        UserDetail userDetail = mock(UserDetail.class);
        when(userDetail.getName()).thenReturn("Rose");
        when(userMapper.getUserDetailById(1)).thenReturn(userDetail);
        when(userMapper.getUserDetailById(2)).thenReturn(userDetail);

        Response response = target(basePath + "/1,2").request().get();
        Assert.assertEquals(response.getStatus(), 200);
        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        List<Map> homeworkQuizList = (List) result.get("homeworkQuizzes");
        assertThat(homeworkQuizList.size(), is(2));

        Map homeworkItem01 = homeworkQuizList.get(0);

        assertThat(homeworkQuizList.size(), is(2));
        assertThat(homeworkItem01.get("id"), is(1));
        assertThat(homeworkItem01.get("description"), is("这是一道比较简单的题目"));
        assertThat(homeworkItem01.get("evaluateScript"), is("www.baidu.com"));
        assertThat(homeworkItem01.get("templateRepository"), is("templateRepository"));

        Map homeworkItem02 = homeworkQuizList.get(1);

        assertThat(homeworkItem02.get("id"), is(2));
        assertThat(homeworkItem02.get("description"), is("这是一道普通难度的题目"));

        assertThat(homeworkItem02.get("evaluateScript"), is("www.talkop.com"));
        assertThat(homeworkItem02.get("templateRepository"), is("talkopRepository"));
    }

    @Test
    public void should_return_homework_quiz_by_id() {
        when(homeworkQuizMapper.findById(1)).thenReturn(homeworkQuiz);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");

        UserDetail userDetail = mock(UserDetail.class);
        when(userDetail.getName()).thenReturn("Rose");
        when(userMapper.getUserDetailById(homeworkQuiz.getMakerId())).thenReturn(userDetail);


        Response response = target("homeworkQuizzes/1").request().get();

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        Map homeworkItem = (Map)result.get("homeworkItem");

        assertThat(homeworkItem.get("id"), is(1));
        assertThat(homeworkItem.get("description"), is("这是一道比较简单的题目"));
        assertThat(homeworkItem.get("evaluateScript"), is("www.baidu.com"));
        assertThat(homeworkItem.get("templateRepository"), is("templateRepository"));
    }

    @Test
    public void should_return_all_homework_quiz_List() {


        List<HomeworkQuiz> homeworkQuizzes = mock(List.class);
        when(homeworkQuizMapper.findAllHomeworkQuizzes()).thenReturn(homeworkQuizzes);

        Iterator iterator = mock(Iterator.class);
        when(iterator.hasNext()).thenReturn(true, true, false);
        when(iterator.next()).thenReturn(homeworkQuiz, homeworkQuiz01);

        when(homeworkQuizzes.iterator()).thenReturn(iterator);

        when(homeworkQuiz.getMakerId()).thenReturn(1);
        when(homeworkQuiz.getDescription()).thenReturn("这是一道比较简单的题目");
        when(homeworkQuiz.getEvaluateScript()).thenReturn("www.baidu.com");
        when(homeworkQuiz.getTemplateRepository()).thenReturn("templateRepository");

        when(homeworkQuiz01.getMakerId()).thenReturn(2);
        when(homeworkQuiz01.getDescription()).thenReturn("这是一道普通难度的题目");
        when(homeworkQuiz01.getEvaluateScript()).thenReturn("www.talkop.com");
        when(homeworkQuiz01.getTemplateRepository()).thenReturn("talkopRepository");


        UserDetail userDetail = mock(UserDetail.class);
        when(userDetail.getName()).thenReturn("Rose");
        when(userMapper.getUserDetailById(1)).thenReturn(userDetail);
        when(userMapper.getUserDetailById(2)).thenReturn(userDetail);

        Response response = target(basePath).request().get();
        Assert.assertEquals(response.getStatus(), 200);
        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        List<Map> homeworkQuizList = (List) result.get("homeworkQuizzes");
        assertThat(homeworkQuizList.size(), is(2));

        Map homeworkItem01 = homeworkQuizList.get(0);

        assertThat(homeworkQuizList.size(), is(2));

        assertThat(homeworkItem01.get("id"), is(1));
        assertThat(homeworkItem01.get("description"), is("这是一道比较简单的题目"));
        assertThat(homeworkItem01.get("evaluateScript"), is("www.baidu.com"));
        assertThat(homeworkItem01.get("templateRepository"), is("templateRepository"));

        Map homeworkItem02 = homeworkQuizList.get(1);

        assertThat(homeworkItem02.get("id"), is(2));
        assertThat(homeworkItem02.get("description"), is("这是一道普通难度的题目"));
        assertThat(homeworkItem02.get("evaluateScript"), is("www.talkop.com"));
        assertThat(homeworkItem02.get("templateRepository"), is("talkopRepository"));

    }

    @Test
    public void should_return_homework_quiz_uri() {

        HomeworkQuiz homeworkQuiz = new HomeworkQuiz();

        homeworkQuiz.setDescription("desctiption");
        homeworkQuiz.setEvaluateScript("evaluateScript.sh");
        homeworkQuiz.setTemplateRepository("http://github.com/templateRepository");
        homeworkQuiz.setMakerId(1);
        homeworkQuiz.setHomeworkName("homeworkName");

        when(homeworkQuizMapper.insertHomeworkQuiz(homeworkQuiz)).thenReturn(1);

        Map map = new HashMap();

        map.put("desctiption","miaoshu");
        map.put("evaluateScript","ceshi ");
        map.put("templateRepository","http://github.com/templateRepository");
        map.put("makerId",1);
        map.put("homeworkName","homeworkName");
        map.put("createTime",123456);

        Entity entity = Entity.entity(map, MediaType.APPLICATION_JSON);

        Response response = target(basePath).request().post(entity);

        MatcherAssert.assertThat(response.getStatus(), is(200));
        Map result = response.readEntity(Map.class);

        MatcherAssert.assertThat(result.size(), is(1));
    }
}