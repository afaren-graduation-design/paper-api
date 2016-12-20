package com.thoughtworks.twars.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MentorResourceTest extends TestBase {

    String basePath = "/mentors";

    @Test
    public void should_return_mentors_uri_by_email() throws Exception {

        String email = "test";
        when(userMapper.findMentorsIdByEmail(email)).thenReturn(Arrays.asList(1, 2, 3));

        Response response = target(basePath + "/test").request().get();
        assertThat(response.getStatus(), is(200));
        Gson gson = new GsonBuilder().create();

        Map result = response.readEntity(Map.class);
        String jsonStr = gson.toJson(result);
        assertThat(jsonStr, is(
                "{\"mentorsUri\":[\"users/1/detail\",\"users/2/detail\",\"users/3/detail\"]}"
        ));
    }


}
