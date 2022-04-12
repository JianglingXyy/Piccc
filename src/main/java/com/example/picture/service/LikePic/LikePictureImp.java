package com.example.picture.service.LikePic;

import com.example.picture.mapper.LikePictureMapper;
import com.example.picture.mapper.PictureMapper;
import com.example.picture.pojo.LikePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Async("taskAsyncPool")
public class LikePictureImp implements LIkePictureService<LikePicture> {
    @Autowired
    private LikePictureMapper mapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public List<Integer> getLikeList(LikePicture likePicture) {
        return mapper.getPictureLikeList(likePicture);
    }
    @Override
    public void likePicture(LikePicture likePicture) {
        if(redisTemplate.opsForHash().hasKey("increase",likePicture.getPid())){
            redisTemplate.opsForHash().increment("increase",likePicture.getPid(),1);
        }
        else{
            redisTemplate.opsForHash().put("increase",likePicture.getPid(),1);
        }

                if(mapper.exist(likePicture) ){
                    mapper.updateLikeList(likePicture);
                }
                else
                    mapper.insert(likePicture);

    }

    @Override
    public void unlikePicture(LikePicture likePicture) {
        if(redisTemplate.opsForHash().hasKey("increase",likePicture.getPid())){
            redisTemplate.opsForHash().increment("increase",likePicture.getPid(),-1);
            if ((int)(redisTemplate.opsForHash().get("increase",likePicture.getPid()))==0){
                redisTemplate.opsForHash().delete("increase",likePicture.getPid());
            }
        }
        mapper.updateLikeList(likePicture);
        mapper.refreshPicLikeProperty(likePicture);
    }
}
