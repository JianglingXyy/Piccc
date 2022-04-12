package com.example.picture.service.LoadRegist;


import com.example.picture.mapper.UserMapper;
import com.example.picture.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.util.concurrent.TimeUnit;

@Component
public class LoadRegist implements LoadRegister {
    @Autowired
     private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private  String mailSender;
    @Autowired
    private UserMapper mapper;
    @Override
    public boolean regist1(String mail) {
        String s = String.valueOf((int)((Math.random()*9+1)*100000));
        MimeMessage mailMessage = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage,false);
            helper.setFrom(mailSender);
            helper.setTo(mail);
            helper.setSubject("Pic注册服务");
            helper.setText("您好!您的验证码为"+s+"有效时间5分钟");
            sender.send(mailMessage);
            stringRedisTemplate.opsForValue().set(mail,s,60*5, TimeUnit.SECONDS);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int regist2(String mail,String id) {
        if(Boolean.TRUE.equals(stringRedisTemplate.hasKey(mail))){
            if (id.equals(stringRedisTemplate.opsForValue().get(mail))){
                stringRedisTemplate.delete(mail);
                return  1;
            }
            else
                //验证码不对
                return 2;
        }
        else
            //验证码过期
            return 3;
    }

    @Override
    public boolean mailExist(String mail) {
        return mapper.mailExist(mail);
    }

    @Override
    public boolean load(User user) {
         return mapper.isExist(user);
    }
}
