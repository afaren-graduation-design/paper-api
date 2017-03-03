package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.BasicBlankQuiz;
import com.thoughtworks.twars.bean.MultipleChoice;
import com.thoughtworks.twars.bean.SingleChoice;
import com.thoughtworks.twars.mapper.BasicBlankQuizMapper;
import com.thoughtworks.twars.mapper.MultipleChoiceMapper;
import com.thoughtworks.twars.mapper.SingleChoiceMapper;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("/basic-quizzes")
@Api
public class BasicQuizResource {

    @Inject
    private BasicBlankQuizMapper basicBlankQuizMapper;

    @Inject
    private SingleChoiceMapper singleChoiceMapper;

    @Inject
    private MultipleChoiceMapper multipleChoiceMapper;

    @POST
    public Response insertBasicQuizzes(ArrayList<Map> data) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).get("type").equals("SINGLE_CHOICE")) {

                SingleChoice singleChoice  = new SingleChoice();
                singleChoice.setType((String) data.get(i).get("type"));
                singleChoice.setDescription((String) data.get(i).get("description"));
                singleChoice.setAnswer((String) data.get(i).get("answer"));
                singleChoice.setChoices((String) data.get(i).get("choices"));
                singleChoiceMapper.insertSingleChoice(singleChoice);
            }
            if (data.get(i).get("type").equals("MULTIPLE_CHOICE")) {

                MultipleChoice multipleChoice  = new MultipleChoice();
                multipleChoice.setType((String) data.get(i).get("type"));
                multipleChoice.setDescription((String) data.get(i).get("description"));
                multipleChoice.setAnswer((String) data.get(i).get("answer"));
                multipleChoice.setChoices((String) data.get(i).get("choices"));
                multipleChoiceMapper.insertMultipleChoice(multipleChoice);
            }
            if (data.get(i).get("type").equals("BASIC_BLANK_QUIZ")) {

                BasicBlankQuiz basicBlankQuiz  = new BasicBlankQuiz();
                basicBlankQuiz.setType((String) data.get(i).get("type"));
                basicBlankQuiz.setDescription((String) data.get(i).get("description"));
                basicBlankQuiz.setAnswer((String) data.get(i).get("answer"));
                basicBlankQuizMapper.insertBasicBlankQuiz(basicBlankQuiz);
            }
        }
        return Response.status(Response.Status.CREATED).build();

    }
}
