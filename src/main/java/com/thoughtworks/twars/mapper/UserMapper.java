package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.bean.UserDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int insertUser(User user);

    User getUserById(Integer id);

    User getUserByEmail(String email);

    User getUserByMobilePhone(String mobilePhone);

    User getUserByEmailAndPassWord(User user);

    User getUserByMobilePhoneAndPassWord(User user);

    UserDetail getUserDetailById(Integer userId);

    int updateUserDetail(UserDetail detail);

    int updatePassword(
            @Param("id") int id,
            @Param("oldPassword") String oldPassword,
            @Param("password") String password);

    int resetPassword(User user);

    List<UserDetail> findUserDetailsByUserIds(List<Integer> userIds);

    List<User> findUsersByUserIds(List<Integer> userIds);

    List<Integer> findProgramsById(Integer id);

    Integer insertStudentMentor(
            @Param("mentorId") Integer mentorId,
            @Param("studentId") Integer studentId);

    Integer insertUserProgram(
            @Param("userId") Integer userId,
            @Param("programId") Integer programId);

    List<Map> findUsersByInformation(
            @Param("email") String email,
            @Param("privilege") String privilege,
            @Param("newPage") Integer newPage,
            @Param("pageSize") Integer pageSize);

    List<Integer> findMentorIdsByStudentId(Integer id);

    List<Integer> findStudentIdsByMentorId(Integer id);

    int deleteUserByEmail(String email);

    List<User> groupUserByEmail();

    List<String> getUserRolesByEmail(String email);

}
