package com.example.picture.controller;
import com.example.picture.mapper.UserMapper;
import com.example.picture.pojo.Response;

import com.example.picture.service.Pic.PictureIml;
import com.example.picture.utils.FinalParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.picture.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PictureIml pictureIml;
   /**通过id查询用户 **/
    @PostMapping("/queryUserByUId")
    public Response<User> queryUserByUId(@RequestParam int uid){
        User user = userMapper.queryUserByUId(uid);
        if(user == null)
             return  Response.failResponse();
        else
            return Response.ResponseOK(user);
    }

    /**通过名字查询用户*/
    @PostMapping("/queryUserByName")
    public Response<User> queryUserByName(@RequestParam String name){
        User user = userMapper.queryUserByName(name);
        if(user == null){
            return  Response.failResponse();
        }
        else{
            return Response.ResponseOK(user);
        }
    }


    @PostMapping("/queryUserByMail")
    /**
     * 根据邮箱查询
     */
    public Response<User> queryUserByMail(@RequestParam String mail){
        User user = userMapper.queryUserByMail(mail);
        if (user == null)
            return  Response.failResponse();
        else
            return Response.ResponseOK(user);
    }

    @PostMapping("/addUser")
    public Response<Object>addUser(@RequestBody User user){
         if(userMapper.insertUser(user) != 0)
             return Response.ResponseOK();
         else
             return Response.failResponse();
    }

    @PostMapping(value = "/uploadHeadIcon")
    /***上传头像**/
    public Response<Object> uploadHeadIcon(@RequestBody MultipartFile fileUpload,@RequestParam int uid){
         if(pictureIml.savePicture(FinalParameter.pictureBasePath+uid+"/","headIcon",fileUpload)){
             return Response.ResponseOK();
         }
         else
             return Response.failResponse();
    }
    /**下载头像**/
    @ResponseBody
    @RequestMapping(value = "/getHeadIcon",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getHeadIcon(@RequestParam String name)  {
        try (InputStream is = new FileInputStream(FinalParameter.pictureBasePath+name+"/headIcon.jpg")){
           byte []bytes = new byte[is.available()];
           is.read(bytes,0,is.available());
           is.close();
           return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
