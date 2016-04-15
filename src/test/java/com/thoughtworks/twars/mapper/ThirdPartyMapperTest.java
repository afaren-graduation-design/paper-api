package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.ThirdParty;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThirdPartyMapperTest extends TestBase{
    private ThirdPartyMapper thirdPartyMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        thirdPartyMapper = session.getMapper(ThirdPartyMapper.class);
    }

    @Test
    public void should_add_third_party_user() throws Exception {
        ThirdParty thirdParty = new ThirdParty();

        thirdParty.setThirdPartyId(1);
        thirdParty.setUserId(1);

        thirdPartyMapper.insertThirdPartyUser(thirdParty);

        assertThat(thirdParty.getId(), is(1));

    }
}
