package com.example.picture.mapper;

import com.example.picture.pojo.Subscribe;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubscribeMapper {
    //关注
    void subscribe(Subscribe subscribe);
    //取关
    void updateSubscribe(Subscribe subscribe);

    boolean exist(Subscribe subscribe);
    List<Integer> getCommonSubscribe(Subscribe subscribe);

    List<Integer> getFans(int uid);
    List<Integer> getSubscribersList(int uid);

}
