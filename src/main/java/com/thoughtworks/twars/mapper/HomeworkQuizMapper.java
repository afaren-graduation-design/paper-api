package com.thoughtworks.twars.mapper;


import com.thoughtworks.twars.bean.HomeworkQuiz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkQuizMapper {

    List<HomeworkQuiz> findBySectionId(Integer id);

    HomeworkQuiz findById(Integer id);

    int insertHomeworkQuiz(HomeworkQuiz homeworkQuiz);

    List<HomeworkQuiz> findHomeworkQuizzes(
            @Param("homeworkName") String homeworkName,
            @Param("stackId") Integer stackId,
            @Param("newPage") Integer newPage,
            @Param("pageSize") Integer pageSize);
}
