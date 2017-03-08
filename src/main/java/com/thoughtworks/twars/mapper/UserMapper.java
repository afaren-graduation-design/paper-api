package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.bean.UserDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Insert("INSERT INTO users(email, mobilePhone, password, userName,role,createDate)"
            + "VALUES (#{email}, #{mobilePhone}, MD5(#{password}),#{userName},#{role}"
            + ",UNIX_TIMESTAMP())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    @Select("SELECT * FROM users WHERE id = #{id};")
    User getUserById(Integer id);


    @Select("SELECT * FROM users WHERE binary email = #{email} LIMIT 1;")
    User getUserByEmail(String email);

    @Select("SELECT * FROM users WHERE mobilePhone = #{mobilePhone} LIMIT 1;")
    User getUserByMobilePhone(String mobilePhone);

    @Select(" SELECT * FROM users WHERE email regexp binary #{email} AND"
            + " password = MD5(#{password}) LIMIT 1;")
    User getUserByEmailAndPassWord(User user);

    @Select("SELECT * FROM users WHERE mobilePhone = #{email} AND "
            + "password = MD5(#{password}) LIMIT 1;")
    User getUserByMobilePhoneAndPassWord(User user);

    @Select("SELECT * FROM userDetail WHERE userId = #{userId};")
    UserDetail getUserDetailById(Integer userId);

    @Insert("REPLACE INTO userDetail(userId,name,major,school,gender,"
            + "degree,schoolProvince,schoolCity,entranceYear)"
            + "values(#{userId}, #{name},#{major}, #{school}, #{gender},"
            + "#{degree},#{schoolProvince},#{schoolCity},#{entranceYear})")
    int updateUserDetail(UserDetail detail);

    @Update("UPDATE users SET password=MD5(#{password}) WHERE id = #{id} "
            + "AND password=MD5(#{oldPassword});")
    int updatePassword(
            @Param("id") int id,
            @Param("oldPassword") String oldPassword,
            @Param("password") String password);


    @Update("UPDATE users SET password=MD5(#{password}) WHERE binary email= #{email};")
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
            @Param("page") Integer page,
            @Param("pageSize") Integer pageSize);

    List<Integer> findMentorIdsByStudentId(Integer id);

    List<Integer> findStudentIdsByMentorId(Integer id);

    int deleteUserByEmail(String email);

    List<User> groupUserByEmail(@Param("page") Integer page,
                                @Param("pageSize") Integer pageSize,
                                @Param("email") String email,
                                @Param("mobilePhone") String mobilePhone,
                                @Param("role") String role);


    List<String> getUserRolesByEmail(String email);

    List<User> getUserCount(@Param("email") String email,
                            @Param("mobilePhone") String mobilePhone,
                            @Param("role") String role);

}
