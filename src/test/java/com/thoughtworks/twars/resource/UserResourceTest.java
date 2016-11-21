package com.thoughtworks.twars.resource;

import com.thoughtworks.twars.bean.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest extends TestBase {

    User user = mock(User.class);

    String basePath = "/users";

    @Test
    public void should_return_user() {
        when(userMapper.getUserById(1)).thenReturn(user);

        when(user.getId()).thenReturn(1);
        when(user.getEmail()).thenReturn("111@222.com");
        when(user.getMobilePhone()).thenReturn("13111111111");
        when(user.getRole()).thenReturn("1");

        Response response = target(basePath + "/1").request().get();

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        assertThat((Integer) result.get("id"), is(1));
        assertThat((String) result.get("email"), is("111@222.com"));
        assertThat((String) result.get("mobilePhone"), is("13111111111"));
        assertThat((String) result.get("role"), is("1"));
    }

    @Test
    public void should_return_404_when_get_user() {
        when(userMapper.getUserById(90)).thenReturn(null);

        Response response = target(basePath + "/90").request().get();
        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_user_by_field() {
        when(userMapper.getUserByEmail(anyString())).thenReturn(user);
        when(user.getId()).thenReturn(10);

        Response response = target(basePath)
                .queryParam("field", "email")
                .queryParam("value", "abc@test.com")
                .request().get();

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        assertThat((String) result.get("uri"), is("users/10"));

    }

    @Test
    public void should_return_404_when_get_user_detail() {
        when(userMapper.getUserDetailById(90)).thenReturn(null);

        Response response = target(basePath + "/7/detail").request().get();
        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_200_when_get_user_by_email() {
        when(userMapper.getUserByEmail(anyString())).thenReturn(null);

        Response response = target(basePath)
                .queryParam("field", "email")
                .queryParam("value", "abc@test.com")
                .request().get();

        Map result = response.readEntity(Map.class);

        assertThat(response.getStatus(), is(200));
        assertEquals(result.get("uri"), null);
    }

    @Test
    public void should_200_when_get_user_by_mobile_phone() {
        when(userMapper.getUserByMobilePhone(anyString())).thenReturn(null);

        Response response = target(basePath)
                .queryParam("field", "mobilePhone")
                .queryParam("value", "4585295152")
                .request().get();

        Map result = response.readEntity(Map.class);

        assertThat(response.getStatus(), is(200));
        assertEquals(result.get("uri"), null);
    }

    @Test
    public void should_return_user_detail_by_user_id() throws Exception {

        UserDetail theDetail = mock(UserDetail.class);

        when(userMapper.getUserDetailById(1)).thenReturn(theDetail);
        when(userMapper.getUserById(1)).thenReturn(user);
        when(user.getMobilePhone()).thenReturn("123456");
        when(user.getEmail()).thenReturn("11@qq.com");

        when(theDetail.getUserId()).thenReturn(1);
        when(theDetail.getSchool()).thenReturn("哈佛");
        when(theDetail.getMajor()).thenReturn("宗教");
        when(theDetail.getDegree()).thenReturn("博士");
        when(theDetail.getName()).thenReturn("狗剩");
        when(theDetail.getGender()).thenReturn("男");
        when(theDetail.getSchoolProvince()).thenReturn("陕西");
        when(theDetail.getSchoolCity()).thenReturn("西安");
        when(theDetail.getEntranceYear()).thenReturn("2016");

        Response response = target(basePath + "/1/detail").request().get();

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);

        assertThat(result.get("userId"), is(1));
        assertThat(result.get("school"), is("哈佛"));
        assertThat(result.get("major"), is("宗教"));
        assertThat(result.get("degree"), is("博士"));
        assertThat(result.get("name"), is("狗剩"));
        assertThat(result.get("gender"), is("男"));
        assertThat(result.get("mobilePhone"), is("123456"));
        assertThat(result.get("email"), is("11@qq.com"));
        assertThat(result.get("schoolProvince"), is("陕西"));
        assertThat(result.get("schoolCity"), is("西安"));
        assertThat(result.get("entranceYear"), is("2016"));
    }

    @Test
    public void should_return_user_detail_by_user_ids() throws Exception {

        UserDetail theDetail = mock(UserDetail.class);

        when(userMapper.getUserDetailById(1)).thenReturn(theDetail);
        when(userMapper.getUserById(1)).thenReturn(user);
        when(user.getMobilePhone()).thenReturn("123456");
        when(user.getEmail()).thenReturn("11@qq.com");

        when(theDetail.getUserId()).thenReturn(1);
        when(theDetail.getSchool()).thenReturn("哈佛");
        when(theDetail.getMajor()).thenReturn("宗教");
        when(theDetail.getDegree()).thenReturn("博士");
        when(theDetail.getName()).thenReturn("狗剩");
        when(theDetail.getGender()).thenReturn("男");
        when(theDetail.getSchoolProvince()).thenReturn("陕西");
        when(theDetail.getSchoolCity()).thenReturn("西安");
        when(theDetail.getEntranceYear()).thenReturn("2016");

        when(userMapper.getUserDetailById(2)).thenReturn(theDetail);
        when(userMapper.getUserById(1)).thenReturn(user);
        when(user.getMobilePhone()).thenReturn("78910");
        when(user.getEmail()).thenReturn("22@qq.com");

        when(theDetail.getUserId()).thenReturn(2);
        when(theDetail.getSchool()).thenReturn("麻省理工");
        when(theDetail.getMajor()).thenReturn("计算机科学");
        when(theDetail.getDegree()).thenReturn("硕士");
        when(theDetail.getName()).thenReturn("李明");
        when(theDetail.getGender()).thenReturn("男");
        when(theDetail.getSchoolProvince()).thenReturn("陕西");
        when(theDetail.getSchoolCity()).thenReturn("西安");
        when(theDetail.getEntranceYear()).thenReturn("2016");

        Response response = target(basePath + "/1,2/detail").request().get();
        Map result = response.readEntity(Map.class);
        List<Map> userDetailList = (List) result.get("userList");
        Map userDetail_01 = userDetailList.get(0);
        Map userDetail_02 = userDetailList.get(1);

        assertThat(response.getStatus(), is(200));
        assertThat(userDetailList.size(), is(2));

        assertThat(userDetail_01.get("userId"), is(1));
        assertThat(userDetail_01.get("school"), is("哈佛"));
        assertThat(userDetail_01.get("major"), is("宗教"));
        assertThat(userDetail_01.get("degree"), is("博士"));
        assertThat(userDetail_01.get("name"), is("狗剩"));
        assertThat(userDetail_01.get("gender"), is("男"));
        assertThat(userDetail_01.get("mobilePhone"), is("123456"));
        assertThat(userDetail_01.get("email"), is("11@qq.com"));
        assertThat(userDetail_01.get("schoolProvince"), is("陕西"));
        assertThat(userDetail_01.get("schoolCity"), is("西安"));
        assertThat(userDetail_01.get("entranceYear"), is("2016"));

        assertThat(userDetail_02.get("userId"), is(2));
        assertThat(userDetail_02.get("school"), is("麻省理工"));
        assertThat(userDetail_02.get("major"), is("计算机科学"));
        assertThat(userDetail_02.get("degree"), is("硕士"));
        assertThat(userDetail_02.get("name"), is("李明"));
        assertThat(userDetail_02.get("gender"), is("男"));
        assertThat(userDetail_02.get("mobilePhone"), is("123456"));
        assertThat(userDetail_02.get("email"), is("11@qq.com"));
        assertThat(userDetail_02.get("schoolProvince"), is("陕西"));
        assertThat(userDetail_02.get("schoolCity"), is("西安"));
        assertThat(userDetail_02.get("entranceYear"), is("2016"));
    }

    @Test
    public void should_update_user_detail() throws Exception {
        UserDetail updateUserDetail = new UserDetail();

        updateUserDetail.setUserId(2);

        Entity<UserDetail> entityUserDetail = Entity.entity(updateUserDetail,
                MediaType.APPLICATION_JSON_TYPE);
        Response response = target(basePath + "/2/detail").request().put
                (entityUserDetail);

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);
        assertThat(result.get("uri"), is("userDetail/2"));

    }

    @Test
    public void should_insert_user_detail() throws Exception {
        UserDetail insertUserDetail = new UserDetail();

        insertUserDetail.setUserId(18);
        insertUserDetail.setDegree("benke");
        insertUserDetail.setGender("F");
        insertUserDetail.setMajor("cs");
        insertUserDetail.setName("purple");
        insertUserDetail.setSchool("shannxi");
        insertUserDetail.setSchoolProvince("陕西");
        insertUserDetail.setSchoolCity("西安");
        insertUserDetail.setEntranceYear("2016");

        Entity<UserDetail> entityUserDetail = Entity.entity(insertUserDetail,
                MediaType.APPLICATION_JSON_TYPE);
        Response response = target(basePath + "/18/detail").request().put
                (entityUserDetail);

        assertThat(response.getStatus(), is(200));

        Map result = response.readEntity(Map.class);
        assertThat(result.get("uri"), is("userDetail/18"));
    }

    @Test
    public void should_return_404_when_get_no_detail() throws Exception {

        when(userMapper.getUserDetailById(anyInt())).thenReturn(null);

        Response response = target(basePath + "/99/detail").request().get();

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_change_user_password() throws Exception {
        Map userMap = new HashMap<String, String>();

        userMap.put("oldPassword", "25d55ad283aa400af464c76d713c07ad");
        userMap.put("password", "123");

        when(userMapper.updatePassword(1, "25d55ad283aa400af464c76d713c07ad", "123")).thenReturn(1);

        Entity entity = Entity.entity(userMap, MediaType.APPLICATION_JSON);

        Response response = target(basePath + "/1/password").request().put(entity);

        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void should_retrieve_password() throws Exception {

        Response response = target(basePath + "/password/retrieve")
                .queryParam("field", "email")
                .queryParam("value", "test@163.com")
                .request().get();

        Map result = response.readEntity(Map.class);

        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void should_return_logic_puzzle_result() throws Exception {

        ScoreSheet scoreSheet = new ScoreSheet();
        scoreSheet.setExamerId(1);
        scoreSheet.setId(2);
        when(scoreSheetMapper.findOneByUserId(1)).thenReturn(scoreSheet);

        BlankQuizSubmit blankQuizSubmit = new BlankQuizSubmit();
        blankQuizSubmit.setId(4);
        blankQuizSubmit.setBlankQuizId(5);
        blankQuizSubmit.setEndTime(123456);
        blankQuizSubmit.setStartTime(123456);
        blankQuizSubmit.setScoreSheetId(2);
        when(blankQuizSubmitMapper.findByScoreSheetId(2)).thenReturn(Arrays.asList(blankQuizSubmit));

        ItemPost itemPost = new ItemPost();
        itemPost.setId(6);
        itemPost.setBlankQuizSubmitsId(4);
        itemPost.setAnswer("111");
        itemPost.setQuizItemId(7);
        when(itemPostMapper.findByBlankQuizSubmit(4)).thenReturn(Arrays.asList(itemPost));

        QuizItem quizItem = new QuizItem();
        quizItem.setId(7);
        quizItem.setAnswer("111");
        when(quizItemMapper.getQuizItemById(7)).thenReturn(quizItem);

        Response response = target(basePath + "/1/logicPuzzle").request().get();
        assertThat(response.getStatus(), is(200));
    }
}