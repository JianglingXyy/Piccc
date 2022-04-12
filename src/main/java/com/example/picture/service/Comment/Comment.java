package com.example.picture.service.Comment;

import com.example.picture.pojo.CommentChild;
import com.example.picture.pojo.CommentParent;

import java.util.List;

public interface Comment {
    /**
     * 根据图片id获得评论列表
     * @param pid
     * @return
     */
    List<CommentParent> getParentCommentByPid(int pid);

    List<CommentChild> getChildCommentByPid(int pid);

    /**
     * 添加评论
     * @param comment
     */
    void addParentComment(CommentParent comment);

    /**
     * 删除父评论，会自动删除子评论
     * @param comment
     */
    void deleteParentComment(CommentParent comment);

    void addChildComment(CommentChild commentChild);

    void deleteChildComment(CommentChild commentChild);


}
