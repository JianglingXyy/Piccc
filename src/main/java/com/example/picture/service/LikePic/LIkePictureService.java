package com.example.picture.service.LikePic;

import com.example.picture.pojo.LikePicture;
import com.example.picture.pojo.Picture;

import java.util.List;

public interface LIkePictureService<T> {
    List<Integer> getLikeList(T o);

    void likePicture(T o);

    void unlikePicture(T o);

}
