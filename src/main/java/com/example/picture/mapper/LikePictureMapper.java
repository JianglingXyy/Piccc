package com.example.picture.mapper;

import com.example.picture.pojo.LikePicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface LikePictureMapper {
    List<Integer> getPictureLikeList(LikePicture likePicture);
    void updateLikeList(LikePicture likePicture);
    boolean exist(LikePicture likePicture);
    void refreshPicLikeProperty(LikePicture likePicture);
    void insert(LikePicture likePicture);
}
