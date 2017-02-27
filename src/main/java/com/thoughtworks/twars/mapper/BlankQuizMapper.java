package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.BlankQuiz;

import java.util.List;

public interface BlankQuizMapper {

    List<BlankQuiz> findAll();

    List<BlankQuiz> findBySectionId(Integer sectionId);

    BlankQuiz findOne(Integer id);

    int insertBlankQuiz(BlankQuiz blankQuiz);

}
