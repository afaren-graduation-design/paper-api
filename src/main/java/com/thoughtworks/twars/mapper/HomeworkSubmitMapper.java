package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.HomeworkSubmit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkSubmitMapper {

    int insertHomeworkSubmit(HomeworkSubmit homeworkSubmit);

    List<HomeworkSubmit> findByScoreSheetId(int scoreSheetId);

    HomeworkSubmit findByScoreSheetIdAndQuizId(
            @Param("scoreSheetId") Integer scoreSheetId,
            @Param("homeworkQuizId") Integer homeworkQuizId);
}
