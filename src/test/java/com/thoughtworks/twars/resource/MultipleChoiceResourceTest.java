package com.thoughtworks.twars.resource;


import com.thoughtworks.twars.bean.MultipleChoice;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class MultipleChoiceResourceTest extends TestBase {

    String basePath = "/multipleChoices";

    @Test
    public void should_insert_mutiple_choice() {

        MultipleChoice multipleChoice = new MultipleChoice();

        multipleChoice.setType("MULTIPLE_CHOICE");
        multipleChoice.setDescription("这是一道多选题");
        multipleChoice.setOptions("aa,bb,cc,dd");
        multipleChoice.setAnswer("aa,bb");

        when(multipleChoiceMapper.insertMultipleChoice(multipleChoice)).thenReturn(1);

        Response response = target(basePath).request().post(
                Entity.entity(multipleChoice, MediaType.APPLICATION_JSON), Response.class);
        assertThat(response.getStatus(), is(201));

    }

}
