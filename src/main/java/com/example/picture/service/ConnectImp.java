package com.example.picture.service;

import com.example.picture.pojo.HeartBeat;
import com.example.picture.pojo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Component;


import java.util.*;
import java.util.concurrent.TimeUnit;

@Component

public class ConnectImp implements ConnectService{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    /**
     * 查询某个人的ip信息
     */
    public HeartBeat queryHeartBeat(int uid) {
        return (HeartBeat) redisTemplate.opsForHash().get("heartBeat",uid);
    }

    /**
     * 连接,定时刷新
     */
    @Override
    public void refreshHeartBeat(HeartBeat heartBeat) {
        redisTemplate.opsForHash().put("heartBeat",heartBeat.getUid(),heartBeat);
        redisTemplate.expire("heartBeat",5*60, TimeUnit.SECONDS);
    }

    /**
     * 存储信息
     * @param msg
     */
    @Override
    public void storeMsg(Msg msg) {
        redisTemplate.opsForHash().put(String.valueOf(msg.getToUid()), UUID.randomUUID(),msg);
    }

    @Override
    public void deleteMsg(int uid) {
        redisTemplate.delete(String.valueOf(uid));
    }

    @Override
    public List<Object> getMsg(int uid) {
        Map<Object,Object> map = redisTemplate.opsForHash().entries(String.valueOf(uid));
        Collection<Object> collection = map.values();
        return new ArrayList<>(collection);
    }
}
