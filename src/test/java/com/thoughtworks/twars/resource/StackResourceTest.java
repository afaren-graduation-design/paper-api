package com.thoughtworks.twars.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.twars.bean.Stack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StackResourceTest extends TestBase {
    String basePath = "/stacks";

    @Mock
    Stack stackOne;

    @Mock
    Stack stackTwo;

    @Test
    public void should_return_all_stack() throws Exception {
        when(stackOne.getStackId()).thenReturn(1);
        when(stackOne.getTitle()).thenReturn("C#");
        when(stackTwo.getStackId()).thenReturn(2);
        when(stackTwo.getTitle()).thenReturn("java");

        Map m1 = new HashMap();
        m1.put("stackId", 1);
        m1.put("title", "C#");

        Map m2 = new HashMap();
        m2.put("stackId", 2);
        m2.put("title", "java");
        when(stackOne.getResponseInfo()).thenReturn(m1);
        when(stackTwo.getResponseInfo()).thenReturn(m2);

        when(stackMapper.getAllStack())
                .thenReturn(Arrays.asList(stackOne, stackTwo));

        Response response = target(basePath).request().get();
        assertThat(response.getStatus(), is(200));

        Gson gson = new GsonBuilder().create();

        Map result = response.readEntity(Map.class);
        String jsonStr = gson.toJson(result);

        Assert.assertThat(jsonStr, is("{\"items\":[{\"stackId\":1,"
                + "\"title\":\"C#\"},"
                + "{\"stackId\":2,"
                + "\"title\":\"java\"}]}"
        ));

    }

}

