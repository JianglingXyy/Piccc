package com.example.picture.service.Subscribe;

import com.example.picture.mapper.SubscribeMapper;
import com.example.picture.mapper.UserMapper;
import com.example.picture.pojo.Subscribe;
import com.example.picture.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class SubscribeImp implements SubscribeService{
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private UserMapper userMapper;
    @Override//点赞
    public void subscribe(Subscribe subscribe) {

        userMapper.updateSubscribe(subscribe);
        userMapper.updateFollow(subscribe);
        if(subscribeMapper.exist(subscribe)){
            subscribeMapper.updateSubscribe(subscribe);
        }
        else
        subscribeMapper.subscribe(subscribe);
    }
    //取消点赞
    @Override
    public void unSubscribe(Subscribe subscribe) {
        userMapper.updateSubscribe(subscribe);
        userMapper.updateFollow(subscribe);
        subscribeMapper.updateSubscribe(subscribe);
    }

    @Override
    public List<User> getCommonSubscribe(Subscribe subscribe) {
         List<Integer> list  = subscribeMapper.getCommonSubscribe(subscribe);
         return userMapper.getUsers(list);
    }

    @Override
    public List<User> getSubscribersUser(int uid) {
        List<Integer> list = subscribeMapper.getSubscribersList(uid);
        return userMapper.getUsers(list);
    }

    @Override
    public List<Integer> getSubscribersList(int uid) {
        return subscribeMapper.getSubscribersList(uid);
    }

    @Override
    public List<User> getFans(int uid) {
       List<Integer> list = subscribeMapper.getFans(uid);
       return userMapper.getUsers(list);
    }
}
