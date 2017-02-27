package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Paper;

import java.util.List;

public interface PaperMapper {
    List<Paper> findPapersByProgramId(Integer programId);

    List<Paper> findAll();

    Paper getPaperById(Integer id);

    List<Paper> getAllPapers(Integer page, Integer pageSize);

    Paper getOnePaper(Integer id);

    int insertPaper(Paper paper);


}
