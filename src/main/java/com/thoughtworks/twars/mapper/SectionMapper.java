package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Section;

import java.util.List;

public interface SectionMapper {

    List<Section> getSectionsByPaperId(Integer paperId);

    int insertSection(Section section);
}
