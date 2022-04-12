package com.example.picture.controller;

import com.example.picture.mapper.UserMapper;
import com.example.picture.pojo.Response;
import com.example.picture.pojo.User;
import com.example.picture.service.LoadRegist.LoadRegist;
import com.example.picture.utils.FinalParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
@RequestMapping("/loadRegister")
@RestController
public class LoadRegistrController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoadRegist loadRegist;
    @PostMapping("/r1")
    /**
     * Description: 注册1阶段
     * @author ling
     * @createTime 2022/4/2
     * @param [java.lang.String, java.lang.String]
     * @return Response
     */

    public Response<Object> register1(@RequestParam String mail){
         if(loadRegist.mailExist(mail)){
             return Response.failResponse(401);
         }
         if(loadRegist.regist1(mail)){
             return  Response.ResponseOK();
         }
         else
             return Response.failResponse();
    }

    @GetMapping("/r2")
    /**
     * Description: 注册2阶段
     * @author ling
     * @createTime 2022/4/2
     * @param [com.example.picture.pojo.User, java.lang.String]
     * @return Response
     */
    public Response<Object> register2(@RequestParam String mail, @RequestParam String code){
        switch (loadRegist.regist2(mail,code)){
            case 1:
                   return Response.ResponseOK();
            case 2:
                //验证码不对
                return Response.failResponse();
            default:
               //过期
                return Response.failResponse(401);
        }
    }
   @PostMapping("/r3")
    public Response<Object> register3(@RequestBody User user){
        if(userMapper.insertUser(user) != 0){
            File file = new File(FinalParameter.pictureBasePath+userMapper.getLastUId()+"/");
            while (!file.mkdirs()) ;
            return Response.ResponseOK();
        }
        else
            return Response.failResponse();
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/load")
    public Response<Object> response(@RequestBody User user){
        if(loadRegist.load(user)){
            return  Response.ResponseOK();
        }
        else
            return Response.failResponse();
    }

}
