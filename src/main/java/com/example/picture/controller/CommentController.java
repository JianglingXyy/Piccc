package com.example.picture.controller;

import com.example.picture.pojo.CommentChild;
import com.example.picture.pojo.CommentParent;
import com.example.picture.pojo.Response;
import com.example.picture.service.Comment.CommentImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Async
public class CommentController {
    @Autowired
    private CommentImp commentImp;
    @PostMapping("/getParentComment")
    public Response<List<CommentParent>> getParentComment(@RequestParam int pid){
        return Response.ResponseOK(commentImp.getParentCommentByPid(pid));
    }
    @PostMapping("/getChildComment")
    public Response<List<CommentChild>> getChildComment(@RequestParam int pid){
        return Response.ResponseOK(commentImp.getChildCommentByPid(pid));
    }
    @PostMapping("/addPc")
    public  Response<Object> addPc(@RequestBody CommentParent commentParent){
        commentImp.addParentComment(commentParent);
        return Response.ResponseOK();
    }

    @PostMapping("/addCc")
    public Response<Object> addCc(@RequestBody CommentChild commentChild){
        commentImp.addChildComment(commentChild);
        return Response.ResponseOK();
    }

    @PostMapping("/deletePc")
    public Response<Object> deletePc(@RequestBody CommentParent commentParent){
        commentImp.deleteParentComment(commentParent);
        return Response.ResponseOK();
    }

    @PostMapping("/deleteCc")
    public Response<Object> deleteCc(@RequestBody CommentChild commentChild){
        commentImp.deleteChildComment(commentChild);
        return Response.ResponseOK();
    }
}
