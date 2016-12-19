package com.thoughtworks.twars.mapper;

import java.util.List;

public interface ProgramMapper {

    List<Integer> findUsersIdByProgramId(int id);

}
