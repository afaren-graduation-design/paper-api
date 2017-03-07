package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.SectionQuiz;
import org.apache.ibatis.annotations.Param;
import scala.Int;

import java.util.List;

public interface SectionQuizMapper {

    List<SectionQuiz> findBySectionId(Integer sectionId );

    int insertSectionQuiz(SectionQuiz sectionQuiz);

    Integer getSectionQuizIdBySectionIdAndQuizId(
            @Param("quizId") Integer quizId,
            @Param("sectionId") Integer sectionId);
}
