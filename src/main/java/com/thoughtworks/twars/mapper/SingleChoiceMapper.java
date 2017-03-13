package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.SingleChoice;

import java.util.Map;

public interface SingleChoiceMapper {
    int insertSingleChoice(SingleChoice singleChoice);

    SingleChoice getSingleChoiceById(Integer id);
}
