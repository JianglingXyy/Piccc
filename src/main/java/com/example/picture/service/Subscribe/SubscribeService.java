package com.example.picture.service.Subscribe;

import com.example.picture.pojo.Subscribe;
import com.example.picture.pojo.User;


import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface SubscribeService {
    //关注
    void subscribe(Subscribe subscribe);
    //取关
    void unSubscribe(Subscribe subscribe);

     List<User> getCommonSubscribe(Subscribe subscribe);

     List<User> getSubscribersUser(int uid);

     List<Integer> getSubscribersList(int uid);
     List<User> getFans(int uid);

}
