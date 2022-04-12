package com.example.picture.pojo;




import java.sql.Timestamp;


public class CommentChild extends CommentParent{



   public CommentChild(int cid, int uid, int pid, Timestamp commentDate, String content) {
      super(cid, uid, pid, commentDate, content);
   }

   public CommentChild() {
   }

}
