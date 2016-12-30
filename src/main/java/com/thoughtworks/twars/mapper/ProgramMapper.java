package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Program;

import java.util.List;

public interface ProgramMapper {

    List<Integer> findUsersIdByProgramId(int id);

    List<Program> getAllPrograms(int page,int pageSize);

}
