package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.ScoreSheet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreSheetMapper {

    List<ScoreSheet> findAll();

    ScoreSheet findOne(Integer id);

    int insertScoreSheet(ScoreSheet scoreSheet);

    ScoreSheet selectScoreSheet(ScoreSheet scoreSheet);

    ScoreSheet findOneByUserId(Integer userId);

    List<ScoreSheet> findByPaperId(@Param("paperId") Integer id,
                                   @Param("examerId") Integer examerId);

    List<Integer> findUserIdsByPaperId(Integer paperId);
}
