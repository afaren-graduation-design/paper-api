package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.HomeworkQuiz;

import java.util.List;

public interface HomeworkQuizMapper {

    List<HomeworkQuiz> findBySectionId(int id);

    HomeworkQuiz findById(int id);

    int insertHomeworkQuiz(HomeworkQuiz homeworkQuiz);

    List<HomeworkQuiz> findHomeworkQuizzes(
            String homeworkName, String type, int page, int pageSize);

}
