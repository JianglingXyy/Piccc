package com.example.picture.service.LoadRegist;

import com.example.picture.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRegister {
    boolean regist1(String mail);

    int regist2(String name,String id);
    boolean mailExist(String mail);
    boolean load(User user);
}
