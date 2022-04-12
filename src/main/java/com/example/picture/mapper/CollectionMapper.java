package com.example.picture.mapper;

import com.example.picture.pojo.Collections;
import com.example.picture.pojo.LikePicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CollectionMapper {
    List<Integer> getCollectionList(Collections c);
    void updateCollectionList(Collections c);
    boolean exist(Collections likePicture);
    void refreshPicCollectionProperty(Collections c);
    void insert(Collections c);
}
