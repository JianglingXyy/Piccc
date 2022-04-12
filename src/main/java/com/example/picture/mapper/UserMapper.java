package com.example.picture.mapper;

import com.example.picture.pojo.Subscribe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.example.picture.pojo.User;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;

//表示这个注解为mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    User queryUserByMail(String mail);

    User queryUserByUId(int uid);

    User queryUserByName(String name);

    int insertUser(User user);

    boolean updateFollow (Subscribe subscribe);

    boolean updateSubscribe(Subscribe subscribe);
    List<User> getUsers(@Param("uids")List<Integer> list);
    int getLastUId();
    boolean mailExist(String mail);
    boolean isExist(User user);
}
