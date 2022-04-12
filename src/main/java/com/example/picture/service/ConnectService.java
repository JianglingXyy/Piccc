package com.example.picture.service;

import com.example.picture.pojo.HeartBeat;
import com.example.picture.pojo.Msg;

import java.util.List;

public interface ConnectService {
    /**
     * 根据uid查询信息
     * @param uid
     * @return
     */
    HeartBeat queryHeartBeat(int uid);



    void refreshHeartBeat(HeartBeat heartBeat);

    /**
     * 保存信息到redis
     * @param msg
     */
    void storeMsg(Msg msg);

    /**
     * 删除redis中的信息
     */

    void deleteMsg(int uid);

    /**
     * 得到redis中的信息
     * @param uid
     */
    List<Object> getMsg(int uid);

}
