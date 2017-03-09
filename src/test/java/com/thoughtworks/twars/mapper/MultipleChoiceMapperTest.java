package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.MultipleChoice;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MultipleChoiceMapperTest extends TestBase {

    private MultipleChoiceMapper multipleChoiceMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        multipleChoiceMapper = session.getMapper(MultipleChoiceMapper.class);
    }

    @Test
    public void should_insert_multipleChoice() throws Exception {
        MultipleChoice multipleChoice = new MultipleChoice();
        multipleChoice.setOptions("ss,aa,cc,bb");
        multipleChoice.setType("MULTIPLE_CHOICE");
        multipleChoice.setDescription("这是第三道多选题");
        multipleChoice.setAnswer("ss");

        multipleChoiceMapper.insertMultipleChoice(multipleChoice);
        assertThat(multipleChoice.getId(), is(3));
    }
}
