package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.BasicBlankQuiz;
import com.thoughtworks.twars.bean.SingleChoice;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SingleChoiceMapperTest extends TestBase {

    private SingleChoiceMapper singleChoiceMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        singleChoiceMapper = session.getMapper(SingleChoiceMapper.class);
    }

    @Test
    public void should_insert_singleChoice() throws Exception {
        SingleChoice singleChoice = new SingleChoice();
        singleChoice.setType("SINGLE_CHOICE");
        singleChoice.setDescription("这是第三道单选题");
        singleChoice.setAnswer("ss");
        singleChoice.setOptions("ss,aa,cc,ff");
        singleChoiceMapper.insertSingleChoice(singleChoice);
        assertThat(singleChoice.getId(), is(3));

    }

    @Test
    public void should_get_singleChoice() throws Exception {
        SingleChoice singleChoice = singleChoiceMapper.getSingleChoiceById(1);
        assertThat(singleChoice.getDescription(), is("这是第一道单选题"));
        assertThat(singleChoice.getAnswer(), is("3"));
        assertThat(singleChoice.getOptions(), is("1,2,3,4"));
        assertThat(singleChoice.getType(), is("SINGLE_CHOICE"));
    }

}
