package com.example.picture.service.heatNew;

import com.example.picture.pojo.Picture;

import java.util.List;

public interface NewPublishService {

    void bootToGetNew();

    void  delete();
    void addToNewList(Picture picture);

    void refreshNewList();
}
