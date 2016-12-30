package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Program;
import com.thoughtworks.twars.bean.User;
import org.junit.Before;
import org.junit.Test;
import scala.Int;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ProgramMapperTest extends TestBase {

    private ProgramMapper programMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        programMapper = session.getMapper(ProgramMapper.class);
    }

    @Test
    public void should_return_users_uri_by_program_id() {
        List<Integer> usersId = programMapper.findUsersIdByProgramId(1);
        assertThat(usersId.size(), is(3));
    }

    @Test
    public void should_return_all_programs() {
        List<Program> programs = programMapper.getAllPrograms(0, 3);
        assertThat(programs.size(), is(3));

        assertEquals(programMapper.getAllPrograms(0, 0).size(), 0);
    }

}