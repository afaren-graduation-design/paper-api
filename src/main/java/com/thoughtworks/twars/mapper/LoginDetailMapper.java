package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.LoginDetail;

import java.util.List;

public interface LoginDetailMapper {

    List<LoginDetail> getLoginDetailByUserId(Integer userId);

    int insertLoginDetail(Integer userId);

    int updateLoginDetail(String token);

    int updateLoginDetailById(Integer id);

    LoginDetail getLoginDetailByToken(String token);

}
