package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PaperMapper {
    List<Paper> findPapersByProgramId(Integer programId);

    List<Paper> findAll();

    Paper getPaperById(Integer id);

    List<Paper> getAllPapers(@Param("newPage") Integer newPage,
                             @Param("pageSize") Integer pageSize);

    Paper getOnePaper(Integer id);

    int insertPaper(Paper paper);

    Map getExamerCountByPaperId(Integer paperId);


}
