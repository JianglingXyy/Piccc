package com.example.picture.controller;

import com.example.picture.pojo.Collections;
import com.example.picture.pojo.LikePicture;
import com.example.picture.pojo.Response;
import com.example.picture.service.Collection.CollectionImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CollectionController {
    @Autowired
    private CollectionImp imp;

    @PostMapping("/coPicture")
    public Response<Collections> likePic(@RequestBody Collections collections){
        imp.collectPicture(collections);
        return Response.ResponseOK();
    }
    @PostMapping("/unCoPicture")
    public Response<Collections> unLikePic(@RequestBody Collections collections){
        imp.uncollectPicture(collections);
        return Response.ResponseOK();
    }
    @PostMapping("/getColist")
    public Response<List<Integer>> getLikelist(@RequestBody Collections collections){
        return Response.ResponseOK(imp.getCollectionList(collections));
    }
}
