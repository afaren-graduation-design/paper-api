package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.HomeworkPostHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HomeworkPostHistoryMapper {

    int insertHomeworkPostHistory(HomeworkPostHistory homeworkPostHistory);

    List<HomeworkPostHistory> findByHomeworkSubmitId(Integer homeworkSubmitId);

    List<Map> getHistoryByExamerIdAndPaperId(
            @Param("examerId") Integer examerId,
            @Param("paperId") Integer paperId
    );

}
