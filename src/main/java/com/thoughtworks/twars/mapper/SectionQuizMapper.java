package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.SectionQuiz;

import java.util.List;

public interface SectionQuizMapper {

    List<SectionQuiz> findBySectionId(Integer sectionId );

    int insertSectionQuiz(SectionQuiz sectionQuiz);
}
