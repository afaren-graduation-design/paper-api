package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.MultipleChoice;

import java.util.Map;

public interface MultipleChoiceMapper {
    int insertMultipleChoice(MultipleChoice multipleChoice);

    MultipleChoice getMultipleChoiceById(Integer id);

}
