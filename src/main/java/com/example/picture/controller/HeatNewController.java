package com.example.picture.controller;

import com.example.picture.pojo.Picture;
import com.example.picture.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HeatNewController {
    @Autowired
    private RedisTemplate<String ,Object> template;
    @GetMapping("/getHeat")
    public  Response<List<Object>> etHeatPicture(){
        if(Boolean.TRUE.equals(template.hasKey("heat"))){
            return Response.ResponseOK(template.opsForList().range("heat",0,99));
        }
        else
            return Response.failResponse("error");
    }
}
