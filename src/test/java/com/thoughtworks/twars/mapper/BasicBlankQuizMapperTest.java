package com.thoughtworks.twars.mapper;


import com.thoughtworks.twars.bean.BasicBlankQuiz;
import com.thoughtworks.twars.bean.SingleChoice;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BasicBlankQuizMapperTest extends TestBase {

    private BasicBlankQuizMapper basicBlankQuizMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        basicBlankQuizMapper = session.getMapper(BasicBlankQuizMapper.class);
    }

    @Test
    public void should_insert_basicBlankQuizMapper() {
        BasicBlankQuiz basicBlankQuiz = new BasicBlankQuiz();
        basicBlankQuiz.setType("BASIC_BLANK_QUIZ");
        basicBlankQuiz.setDescription("这是第三道填空题");
        basicBlankQuiz.setAnswer("javaScript");
        basicBlankQuizMapper.insertBasicBlankQuiz(basicBlankQuiz);
        assertThat(basicBlankQuiz.getId(), is(3));
    }

    @Test
    public void should_get_basicBlankQuiz_by_id() {
        BasicBlankQuiz basicBlankQuiz = basicBlankQuizMapper.getBasicBlankQuizById(1);
        assertThat(basicBlankQuiz.getDescription(), is("这是第一道填空题"));
        assertThat(basicBlankQuiz.getAnswer(), is("javaScript"));
        assertThat(basicBlankQuiz.getType(), is("BASIC_BLANK_QUIZ"));
    }
}
