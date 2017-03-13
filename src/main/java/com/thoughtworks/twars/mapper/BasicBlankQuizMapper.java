package com.thoughtworks.twars.mapper;


import com.thoughtworks.twars.bean.BasicBlankQuiz;

import java.util.Map;

public interface BasicBlankQuizMapper {

    int insertBasicBlankQuiz(BasicBlankQuiz basicBlankQuiz);

    BasicBlankQuiz getBasicBlankQuizById( Integer id);
}
