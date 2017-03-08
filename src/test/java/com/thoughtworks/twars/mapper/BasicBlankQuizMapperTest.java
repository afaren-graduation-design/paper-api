package com.thoughtworks.twars.mapper;


import com.thoughtworks.twars.bean.BasicBlankQuiz;
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
    public void should_insert_basicBlankQuizMapper() throws Exception {
        BasicBlankQuiz basicBlankQuiz = new BasicBlankQuiz();
        basicBlankQuiz.setType("BASIC_BLANK_QUIZ");
        basicBlankQuiz.setDescription("这是第三道填空题");
        basicBlankQuiz.setAnswer("javaScript");
        basicBlankQuizMapper.insertBasicBlankQuiz(basicBlankQuiz);
        assertThat(basicBlankQuiz.getId(), is(3));
    }

}
