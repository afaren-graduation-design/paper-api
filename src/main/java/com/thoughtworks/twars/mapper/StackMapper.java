package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Stack;

import java.util.List;

public interface StackMapper {
    List<Stack> getAllStack();

    Stack getStackById(Integer stackId);

    Stack getStackByTitle(String title);

    int insertStack(Stack stack);
}
