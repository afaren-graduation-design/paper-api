package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Program;
import com.thoughtworks.twars.bean.User;

import java.util.List;

public interface ProgramMapper {

    List<User> findUsersByProgramId(int id);

    Program getProgramById (int id);
}
