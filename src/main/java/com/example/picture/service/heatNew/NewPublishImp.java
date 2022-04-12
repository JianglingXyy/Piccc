package com.example.picture.service.heatNew;

import com.example.picture.mapper.PictureMapper;
import com.example.picture.pojo.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Slf4j
@Component
public class NewPublishImp implements NewPublishService {
    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @PostConstruct
    @Override
    public void bootToGetNew() {
        redisTemplate.delete("new");
        List<Picture> list = pictureMapper.queryPicturesNew();
        redisTemplate.opsForList().rightPushAll("new",list.toArray());
    }

    @Override
    public void delete() {

    }

    @Override
    public void addToNewList(Picture picture) {
        redisTemplate.opsForList().leftPush("new",picture);
    }

    @Override
    @Scheduled(initialDelay = 24*3600*1000,fixedDelay = 24*3600*1000)
    public void refreshNewList() {
        long time = System.currentTimeMillis();
        long t ;
        do{
            Picture picture = (Picture) redisTemplate.opsForList().rightPop("new");
            assert picture != null;
            log.info("logloglog");
            t = picture.getCreateDate().getTime();
        }while (time-t >= 24 * 60 * 60 * 1000);
    }
}
