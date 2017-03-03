package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.BasicBlankQuiz;
import com.thoughtworks.twars.bean.SingleChoice;
import org.junit.Before;
import org.junit.Test;

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
        singleChoice.setChoices("ss,cc,xx,zz");
        singleChoiceMapper.insertSingleChoice(singleChoice);
        assertThat(singleChoice.getId(), is(3));

    }

}
