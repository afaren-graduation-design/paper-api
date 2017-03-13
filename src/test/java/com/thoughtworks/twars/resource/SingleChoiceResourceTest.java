package com.thoughtworks.twars.resource;


import com.thoughtworks.twars.bean.SingleChoice;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class SingleChoiceResourceTest extends TestBase {

    String basePath = "/singleChoices";

    @Test
    public void should_insert_single_choice() {

        SingleChoice singleChoice = new SingleChoice();

        singleChoice.setType("SINGLE_CHOICE");
        singleChoice.setDescription("这是一道单选题");
        singleChoice.setOptions("aa,bb,cc,dd");
        singleChoice.setAnswer("aa");

        when(singleChoiceMapper.insertSingleChoice(singleChoice)).thenReturn(1);

        Response response = target(basePath).request().post(
                Entity.entity(singleChoice, MediaType.APPLICATION_JSON), Response.class);
        assertThat(response.getStatus(), is(201));

    }

}
