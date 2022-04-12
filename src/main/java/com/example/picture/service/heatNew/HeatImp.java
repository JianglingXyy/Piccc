package com.example.picture.service.heatNew;

import com.example.picture.mapper.PictureMapper;
import com.example.picture.pojo.Picture;
import com.example.picture.service.heatNew.HeatService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
@Slf4j
@Component
public class HeatImp implements HeatService {
    @Autowired
    private  PictureMapper pictureMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //获得热门列表
    @Override
    @PostConstruct
    public void bootToGetHeatList() {
          redisTemplate.delete("heat");
          List<Picture> list = pictureMapper.queryPicturesNew();
          redisTemplate.opsForList().rightPushAll("heat",list.toArray());

    }
    @Scheduled(initialDelay = 2*3600*1000,fixedDelay = 2*3600*1000)
    @Override
    public void refreshHeatList() {
        log.info("logloglog");
        //获得点赞数目增加的条目，《pid，增加数目》
        Map<Object, Object> map = redisTemplate.opsForHash().entries("increase");
        if(!map.isEmpty()) {
            redisTemplate.delete("heat");
            List<Map.Entry<Object, Object>> list = new ArrayList<>(map.entrySet());
            map.clear();
            //按照降序排序
            list.sort((o1, o2) -> (Integer) o2.getValue() - (Integer) o1.getValue());
            List<Integer> list1 = new ArrayList<>();
            for (Map.Entry<Object, Object> i : list
            ) {
                list1.add((int) i.getKey());
            }
            redisTemplate.opsForList().rightPushAll("heat", pictureMapper.getPictures(list1).toArray());
        }

    }

    @Override
    public void deletePicture(int pid) {
        redisTemplate.opsForHash().delete("increase",pid);
        long l = redisTemplate.opsForList().size("heat");
    }
}
