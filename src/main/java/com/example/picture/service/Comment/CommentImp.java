package com.example.picture.service.Comment;

import com.example.picture.mapper.CommentMapper;
import com.example.picture.pojo.CommentChild;
import com.example.picture.pojo.CommentParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class CommentImp implements  Comment{
    @Autowired
    private CommentMapper mapper;
    @Override
    public List<CommentParent> getParentCommentByPid(int pid) {
        return mapper.getParentCommentByPid(pid);
    }

    @Override
    public List<CommentChild> getChildCommentByPid(int pid) {
      return  mapper.getChildCommentByPid(pid);
    }

    @Override
    public void addParentComment(CommentParent comment) {
         mapper.addParentComment(comment);
    }

    @Override
    public void deleteParentComment(CommentParent comment) {
        mapper.deleteParentComment(comment);
    }

    @Override
    public void addChildComment(CommentChild commentChild) {
        mapper.addChildComment(commentChild);
    }

    @Override
    public void deleteChildComment(CommentChild commentChild) {
            mapper.deleteChildComment(commentChild);
    }


}
