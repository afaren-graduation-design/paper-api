package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProgramMapperTest extends TestBase {

    private ProgramMapper programMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        programMapper = session.getMapper(ProgramMapper.class);
    }

    @Test
    public void should_return_users_by_program_id() throws Exception {

        List<User> users = programMapper.findUsersByProgramId(1);

        System.out.println(programMapper.findUsersByProgramId(1));
    }
}