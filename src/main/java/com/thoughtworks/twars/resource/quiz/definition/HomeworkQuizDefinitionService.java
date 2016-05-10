package com.thoughtworks.twars.resource.quiz.definition;

import com.thoughtworks.twars.bean.HomeworkQuiz;
import com.thoughtworks.twars.bean.Section;
import com.thoughtworks.twars.bean.SectionQuiz;
import com.thoughtworks.twars.mapper.HomeworkQuizMapper;
import com.thoughtworks.twars.mapper.SectionMapper;
import com.thoughtworks.twars.mapper.SectionQuizMapper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeworkQuizDefinitionService implements IDefinitionService {

    @Inject
    HomeworkQuizMapper mapper;

    @Inject
    SectionMapper sectionMapper;

    @Inject
    SectionQuizMapper sectionQuizMapper;

    public void setMapper(HomeworkQuizMapper mapper) {
        this.mapper = mapper;
    }

    public void setSectionMapper(SectionMapper sectionMapper) {
        this.sectionMapper = sectionMapper;
    }

    public void setSectionQuizMapper(SectionQuizMapper sectionQuizMapper) {
        this.sectionQuizMapper = sectionQuizMapper;
    }

    @Override
    public int insertQuizDefinition(Map quiz, String description, int paperId) {

        Section section = new Section();
        section.setPaperId(paperId);
        section.setDescription(description);
        section.setType((String) quiz.get("quizType"));

        sectionMapper.insertSection(section);

        List<Map> definitions = (List<Map>) quiz.get("definitions");

        definitions.stream()
                .forEach(definition -> {
                    HomeworkQuiz insertHomework = new HomeworkQuiz();
                    insertHomework.setDescription((String) definition.get("description"));
                    insertHomework.setTemplateRepository((String) definition.get("templateRepository"));
                    insertHomework.setEvaluateScript((String) definition.get("evaluateScript"));

                    mapper.insertHomeworkQuiz(insertHomework);
                    
                    SectionQuiz sectionQuiz = new SectionQuiz();
                    sectionQuiz.setSectionId(section.getId());
                    sectionQuiz.setQuizId(insertHomework.getId());

                    sectionQuizMapper.insertSectionQuiz(sectionQuiz);

                });


        return paperId;
    }

    @Override
    public List<Map> getQuizDefinition(int sectionId) {
        List<HomeworkQuiz> list = mapper.findBySectionId(sectionId);

        return list.stream()
                .map(v -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", v.getId());
                    map.put("definition_uri", "homeworkQuizzes/" + v.getId());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
