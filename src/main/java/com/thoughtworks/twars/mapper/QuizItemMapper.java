package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.QuizItem;

import java.util.List;

public interface QuizItemMapper {

    List<QuizItem> getAllQuizItems();

    int insertQuizItem(QuizItem quizItem);

    QuizItem getQuizItemById(Integer id);

    List<QuizItem> getEasyItems(Integer easyCount);

    List<QuizItem> getNormalItems(Integer normalCount);

    List<QuizItem> getHardItems(Integer hardItems);

    List<QuizItem> getExampleItems(Integer exampleCount);

    List<QuizItem> getExamples();
}
