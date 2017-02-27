package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.PaperAndOperation;

import java.util.List;

public interface PaperAndOperationMapper {
    List<PaperAndOperation> findPapersByProgramId(Integer programId);
}
