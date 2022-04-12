package com.example.picture.service.Collection;

import com.example.picture.mapper.CollectionMapper;
import com.example.picture.pojo.Collections;
import com.example.picture.pojo.LikePicture;
import com.example.picture.service.LikePic.LIkePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
@Async("taskAsyncPool")
@Component
public class CollectionImp implements CollectionServices<Collections>{
    @Autowired
    private CollectionMapper mapper;

    @Override
    public List<Integer> getCollectionList(Collections o) {
        return mapper.getCollectionList(o);
    }

    @Override
    public void collectPicture(Collections o) {
        if(mapper.exist(o) ){
            mapper.updateCollectionList(o);
        }
        else
            mapper.insert(o);
    }

    @Override
    public void uncollectPicture(Collections o) {
        mapper.updateCollectionList(o);
        mapper.refreshPicCollectionProperty(o);
    }
}
