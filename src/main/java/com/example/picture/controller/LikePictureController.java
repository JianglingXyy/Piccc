package com.example.picture.controller;

import com.example.picture.pojo.LikePicture;
import com.example.picture.pojo.Response;
import com.example.picture.service.LikePic.LikePictureImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LikePictureController {
    @Autowired
    private LikePictureImp likePictureImp;
    @PostMapping("/likePicture")
    public Response<Object> likePic(@RequestBody LikePicture likePicture){
        likePictureImp.likePicture(likePicture);
        return Response.ResponseOK();
    }
    @PostMapping("/unLikePicture")
    public Response<Object> unLikePic(@RequestBody LikePicture likePicture){
        likePictureImp.likePicture(likePicture);
        return Response.ResponseOK();
    }
    @PostMapping("/getLikelist")
    public Response<List<Integer>> getLikelist(@RequestBody LikePicture likePicture){
        return Response.ResponseOK(likePictureImp.getLikeList(likePicture));
    }
}
