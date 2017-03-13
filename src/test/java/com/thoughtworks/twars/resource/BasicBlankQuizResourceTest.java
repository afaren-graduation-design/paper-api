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
import static org.mockito.Mockito.when;

public class BasicBlankQuizResourceTest extends TestBase {

    String basePath = "/basicBlankQuizzes";

    @Test
    public void should_insert_basic_blank_quiz() {

        BasicBlankQuiz basicBlankQuiz = new BasicBlankQuiz();

        basicBlankQuiz.setType("BASIC_BLANK_QUIZ");
        basicBlankQuiz.setDescription("这是一道填空题");
        basicBlankQuiz.setAnswer("aa");

        when(basicBlankQuizMapper.insertBasicBlankQuiz(basicBlankQuiz)).thenReturn(1);

        Response response = target(basePath).request().post(
                Entity.entity(basicBlankQuiz, MediaType.APPLICATION_JSON), Response.class);
        assertThat(response.getStatus(), is(201));

    }
}
