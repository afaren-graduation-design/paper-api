package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Program;

import java.util.List;

public interface ProgramMapper {

    List<Integer> findUsersIdByProgramId(Integer id);

    List<Program> getAllPrograms(Integer page,Integer pageSize);

    int insertPrograms(Program program);

    int updatePrograms(Program program);

}
