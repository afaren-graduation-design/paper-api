package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.ThirdParty;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class ThirdPartyResourceTest extends TestBase {
    String basePath = "/auth/thirdParty";

    @Test
    public void should_create_user_when_register_with_github_user() throws Exception {
        ThirdParty thirdParty = new ThirdParty();

        when(thirdPartyMapper.insertThirdPartyUser(thirdParty)).thenReturn(4);
        thirdParty.setThirdPartyUserId(2);
        thirdParty.setUserId(4);

        Entity entity = Entity.entity(thirdParty, MediaType.APPLICATION_JSON);
        Response response = target(basePath + "/github").request().post(entity);
        Map result = response.readEntity(Map.class);
        assertThat(response.getStatus(), is(201));
        assertThat(result.get("userId"), is(4));
    }

    @Test
    public void should_not_return_third_party_user_result() throws Exception {
        Response response = target(basePath + "/github?thirdPartyUserId=1").request().get();
        MatcherAssert.assertThat(response.getStatus(), is(404));
    }
}
