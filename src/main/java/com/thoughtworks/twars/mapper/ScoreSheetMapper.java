package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.ScoreSheet;

import java.util.List;

public interface ScoreSheetMapper {

    List<ScoreSheet> findAll();

    ScoreSheet findOne(Integer id);

    int insertScoreSheet(ScoreSheet scoreSheet);

    ScoreSheet selectScoreSheet(ScoreSheet scoreSheet);

    ScoreSheet findOneByUserId(Integer userId);

    List<ScoreSheet> findByPaperId(Integer paperId);

    List<Integer> findUserIdsByPaperId(Integer paperId);
}
