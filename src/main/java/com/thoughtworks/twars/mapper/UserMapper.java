package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.bean.User;
import com.thoughtworks.twars.bean.UserDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Insert("INSERT INTO users(email, mobilePhone, password, userName,createDate)"
            + "VALUES (#{email}, #{mobilePhone}, MD5(#{password}),#{userName}"
            + ",UNIX_TIMESTAMP())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    //    @Select("SELECT * FROM users WHERE id = #{id};")
    User getUserById(Integer id);

    @Select("DELETE from userRole where userId = #{id};")
    Integer deleteUserRole(Integer id);

    @Select("SELECT * FROM users WHERE binary email = #{email} LIMIT 1;")
    User getUserByEmail(String email);

    @Select("SELECT userId FROM userRole WHERE role = #{role} ORDER BY userId DESC;")
    List<Integer> getUserIdsByRole(Integer role);

    @Select("SELECT * FROM users WHERE mobilePhone = #{mobilePhone} LIMIT 1;")
    User getUserByMobilePhone(String mobilePhone);

    @Select(" SELECT * FROM users WHERE email regexp binary #{email} AND"
            + " password = MD5(#{password}) LIMIT 1;")
    User getUserByEmailAndPassWord(User user);

    @Select("SELECT * FROM users WHERE mobilePhone = #{mobilePhone} LIMIT 1;")
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


    @Select({"<script>",
            "SELECT * FROM userDetail WHERE userId IN",
            "<foreach item= 'userIds' index= 'index' collection='list' ",
            "open='(' separator= ',' close= ')'>",
            "#{userIds}",
            "</foreach>",
            "</script>"})
    List<UserDetail> findUserDetailsByUserIds(List<Integer> userIds);


    @Select({"<script>",
            "SELECT * FROM users WHERE id IN",
            "<foreach item= 'userIds' index='index' collection='list' ",
            "open='(' separator= ','  close= ')'>",
            "#{userIds}",
            "</foreach>",
            "</script>"})
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "mobilePhone", column = "mobilePhone"),
            @Result(id = true, property = "email", column = "email"),
            @Result(id = true, property = "userName", column = "userName")
            })
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

    Integer getUserCount(@Param("email") String email,
                         @Param("mobilePhone") String mobilePhone);

    @Select("SELECT role, COUNT(userId) AS count FROM userRole "
            + "WHERE role IS NOT NULL GROUP BY role ;")
    List<Map> getAllRolesAndCount();


    List<User> getAll(
            @Param("email") String email,
            @Param("mobilePhone") String mobilePhone,
            @Param("page") Integer page,
            @Param("pageSize") Integer pageSize);

    List<Integer> getUserRoleByUserId(Integer id);

    int insertUserRole(@Param("userId") Integer userId, @Param("role") Integer role);

    @Update("UPDATE users SET email =#{email}, mobilePhone = #{mobilePhone},"
            + "password=MD5(#{password}), userName=#{userName} where id = #{id};")
    Integer updateUser(User user);
}
