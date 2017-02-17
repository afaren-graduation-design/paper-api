package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StackMapperTest extends TestBase {
    private StackMapper stackMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        stackMapper = session.getMapper(StackMapper.class);
    }

    @Test
    public void should_return_all_stack() {
        List<Stack> stackList = stackMapper.getAllStack();
        assertThat(stackList.size(), is(3));
    }

    @Test
    public void should_add_stack() {
        Stack stack = new Stack();

        stack.setTitle("JavaScript");
        stack.setDescription("这是JavaScript");
        stack.setDefinition("node:5.8");

        stackMapper.insertStack(stack);

        System.out.println(stack.getStackId());
        assertThat(stack.getStackId(), is(4));
    }
}
