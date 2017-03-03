package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.BasicBlankQuiz;
import com.thoughtworks.twars.bean.MultipleChoice;
import com.thoughtworks.twars.bean.SingleChoice;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

public class BasicQuizResourceTest extends TestBase {

    String basePath = "/basic-quizzes";

    SingleChoice singleChoice = mock(SingleChoice.class);
    MultipleChoice multipleChoice = mock(MultipleChoice.class);
    BasicBlankQuiz basicBlankQuiz = mock(BasicBlankQuiz.class);

    @Test
    public void should_insert_basic_quiz(){

        ArrayList<Map> items = new ArrayList<>();

        Map singleChoice = new HashMap();
        singleChoice.put("type", "SINGLE_CHOICE");
        singleChoice.put("description", "这是一道单选题");
        singleChoice.put("choices", "aa,bb,cc,dd");
        singleChoice.put("answer", "aa");
        items.add(singleChoice);

        Map multipleChoice = new HashMap();
        multipleChoice.put("type", "MULTIPLE_CHOICE");
        multipleChoice.put("description", "这是一道多选题");
        multipleChoice.put("choices", "aa,bb,cc,dd");
        multipleChoice.put("answer", "aa，bb");
        items.add(multipleChoice);

        Entity entity = Entity.entity(items, MediaType.APPLICATION_JSON_TYPE);
        System.out.println(entity);

        Response response = target(basePath).request().post(entity);

        assertThat(response.getStatus(),is(201));



    }
}
