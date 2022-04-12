package com.example.picture.controller;

import com.example.picture.mapper.PictureMapper;
import com.example.picture.pojo.Picture;
import com.example.picture.pojo.Response;
import com.example.picture.service.heatNew.NewPublishImp;
import com.example.picture.service.Pic.PictureIml;
import com.example.picture.utils.FinalParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
public class PictureController {
    @Autowired
    private PictureMapper pictureMapper;
    @Autowired
    private NewPublishImp newPublishImp;
    @Autowired
    private PictureIml pictureIml;

   


    /**
     * Description: 根据创建者获取图片列表
     * @author ling
     * @createTime 2022/4/2 
     * @param [int]
     * @return com.example.picture.pojo.Response
     */
    @GetMapping("/getPicturesByCreator")
    public Response<Object> getPictures(@RequestParam int creator){
        return Response.ResponseOK(pictureMapper.queryPicturesByCreator(creator));
    }
   

    /**
     * Description: 插入图片
     * @author ling
     * @createTime 2022/4/2 
     * @param [Picture,MultipartFile]
     * @return com.example.picture.pojo.Response
     */
    @GetMapping("/insertPicture")
    public Response<Object> insertPicture(@RequestPart Picture picture, @RequestPart MultipartFile file){
        String name = UUID.randomUUID().toString();
        if(pictureIml.savePicture(FinalParameter.pictureBasePath+ picture.getCreator() +"/",name,file)){
            picture.setLocation(FinalParameter.pictureBasePath+picture.getCreator()+"/"+name);
            if(pictureMapper.insertPicture(picture)){
                newPublishImp.addToNewList(picture);
                return Response.ResponseOK();
            }
            else
                return Response.failResponse();
        }

        else
            return Response.failResponse();
    }

    /**
     * Description: 只删除图片
     * @author ling
     * @createTime 2022/4/2 
     * @param [int]
     * @return com.example.picture.pojo.Response
     */
    @GetMapping("/deletePicture")
    public Response<Object> deletePicture(@RequestParam int pid){
        if(pictureMapper.deletePictureByPid(pid))
            return Response.ResponseOK(null);
        else
            return Response.failResponse();
    }

    /**
     * Description: 根据类型获取图片列表
     * @author ling
     * @createTime 2022/4/2
     * @param [int]
     * @return Response
     */
    @GetMapping("/queryByType")
    public Response queryByType(@RequestParam int type){
         return Response.ResponseOK(pictureMapper.queryPicturesByType(type));
    }


    /**
     * Description: 根据pid查询单张图片
     * @author ling
     * @createTime 2022/4/2
     * @param [int]
     * @return Response
     */
    @GetMapping("/queryPicture")
    public Response queryPicture(@RequestParam int pid){
        Picture picture = pictureMapper.queryPictureByPid(pid);
        if(picture == null)
            return Response.failResponse();
        else
            return Response.ResponseOK(picture);
    }

    /**
     * Description: sub加1
     * @author ling
     * @createTime 2022/4/2
     * @param [int]
     * @return Response
     */
    @GetMapping("/addSub")
    public Response addSub(@RequestParam int pid){
        if(pictureMapper.addSubscriber(pid))
            return Response.ResponseOK();
        else
            return Response.failResponse();
    }
    @GetMapping("/addFavor")
    /**
     * Description: like+1
     * @author ling
     * @createTime 2022/4/2
     * @param [int]
     * @return Response
     */

    public Response addFavor(@RequestParam int pid){
        if(pictureMapper.addFavorite(pid))
            return Response.ResponseOK();
        else
            return Response.failResponse();
    }

    @GetMapping("/decreaseFavorite")
    /**
     * Description: like-1
     * @author ling
     * @createTime 2022/4/2
     * @param [int]
     * @return Response
     */

    public Response decreaseFavor(@RequestParam int pid){
        if(pictureMapper.decreaseFavorite(pid))
            return Response.ResponseOK();
        else
            return Response.failResponse();
    }

    @GetMapping("/decreaseSub")
/**
 * Description: sub-1
 * @author ling
 * @createTime 2022/4/2
 * @param [int]
 * @return Response
 */
    public Response decreaseSub(@RequestParam int pid){
        if (pictureMapper.decreaseSubscribe(pid))
            return Response.ResponseOK();
        else
            return Response.failResponse();
    }
    @GetMapping("/getPicturesByList")
    /**
     * Description: 根据list查询图片列表
     * @author ling
     * @createTime 2022/4/2
     * @param [Integer]
     * @return Response
     */
    public Response getPicList(@RequestBody List<Integer> list){
        return Response.ResponseOK(pictureMapper.getPictures(list));
    }
}
