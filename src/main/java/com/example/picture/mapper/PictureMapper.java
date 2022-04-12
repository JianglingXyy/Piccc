package com.example.picture.mapper;

import com.example.picture.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface PictureMapper {

    List<Picture> queryPicturesByCreator(int uid);

    List<Picture> queryPicturesByType(int type);

    boolean insertPicture(Picture picture);

    boolean deletePictureByPid(int pid);

    Picture queryPictureByPid(int pid);

    boolean addSubscriber(int pid);

    boolean addFavorite(int pid);

    boolean decreaseFavorite(int pid);

    boolean decreaseSubscribe(int pid);

    /**通过list<pid>获取图片集合</>**/
    List<Picture> getPictures(@Param("pids") List<Integer> list);

    List<Picture> queryPicturesNew();

}
