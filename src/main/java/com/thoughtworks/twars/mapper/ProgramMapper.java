package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Program;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProgramMapper {

    List<Integer> findUsersIdByProgramId(Integer id);

    List<Program> getAllPrograms(
            @Param("newPage") Integer newPage,
            @Param("pageSize") Integer pageSize);

    int insertPrograms(Program program);

    int updatePrograms(Program program);

}
