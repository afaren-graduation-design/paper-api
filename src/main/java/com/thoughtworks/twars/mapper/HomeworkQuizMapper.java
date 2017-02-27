package com.thoughtworks.twars.mapper;


import com.thoughtworks.twars.bean.HomeworkQuiz;

import java.util.List;

public interface HomeworkQuizMapper {

    List<HomeworkQuiz> findBySectionId(Integer id);

    HomeworkQuiz findById(Integer id);

    int insertHomeworkQuiz(HomeworkQuiz homeworkQuiz);

    List<HomeworkQuiz> findHomeworkQuizzes(
            String homeworkName, Integer stackId, Integer page, Integer pageSize);
}
