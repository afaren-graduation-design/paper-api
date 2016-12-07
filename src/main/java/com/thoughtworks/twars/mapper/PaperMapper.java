package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Paper;

import java.util.List;

public interface PaperMapper {
    List<Paper> findPapersByProgramId(int programId);

    List<Paper> findAll();

    Paper getPaperById(int id);

    List<Paper> getAllPapers(int page , int pageSize);

    Paper getOnePaper(int id);

    int insertPaper(Paper paper);


}
