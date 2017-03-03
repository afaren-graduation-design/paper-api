package com.thoughtworks.twars.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReportsMapperTest extends TestBase {


    private ReportsMapper reportsMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        reportsMapper = session.getMapper(ReportsMapper.class);
    }

    @Test
    public void should_return_all_papers() throws Exception {
        Map map = new HashMap();
        map.put("sql","select * from paper where programId = #{programId};");
        map.put("programId", 1);
        List<Map> result = reportsMapper.selectData(map);
        assertThat(result.size(),is(1) );
    }
}
