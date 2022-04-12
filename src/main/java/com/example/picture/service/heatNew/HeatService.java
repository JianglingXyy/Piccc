package com.example.picture.service.heatNew;

import com.example.picture.pojo.Picture;

import java.util.List;

public interface HeatService {


     //获得热门列表
     void bootToGetHeatList();

     void refreshHeatList();

     void deletePicture(int pid);

}
