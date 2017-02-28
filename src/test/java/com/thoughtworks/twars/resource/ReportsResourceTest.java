package com.thoughtworks.twars.resource;

import com.google.gson.Gson;
import com.thoughtworks.twars.bean.Paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReportsResourceTest extends TestBase {

    Paper paper = mock(Paper.class);
    String basePath = "/reports";

    @Test
    public void should_return_selected_data() throws Exception {

        Response response = target(basePath + "/1")
                .queryParam("data", "%7B%22programId%22%3A1%7D").request().get();

        Map result = response.readEntity(Map.class);

        assertThat(result.size(), is(1));
        assertThat(response.getStatus(), is(200));
    }
}
