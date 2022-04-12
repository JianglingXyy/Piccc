package com.example.picture;

import com.example.picture.mapper.PictureMapper;
import com.example.picture.mapper.UserMapper;

import com.example.picture.service.Comment.CommentImp;

import com.example.picture.service.Subscribe.SubscribeImp;
import com.example.picture.service.heatNew.HeatImp;
import com.example.picture.service.heatNew.NewPublishImp;
import com.example.picture.utils.JudgeYellowPicture;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest
@Slf4j
class PictureApplicationTests {
    @Test
    void contextLoads() throws SQLException {

    }
}
