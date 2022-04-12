package com.example.picture.service.Pic;


import com.example.picture.utils.JudgeYellowPicture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Repository
public class PictureIml implements PictureService {
    @Override
    //将图品存在到指定位置，图片存储的目录
    //name  是图片名字
    // 文件
    public boolean savePicture(String baseUrl,String name, MultipartFile fileUpload) {
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = name+suffixName;
        try {
            //将图片保存到static文件夹里
            File f1 = new File(baseUrl);
            f1.mkdirs();
            File f = new File(baseUrl+fileName);
            fileUpload.transferTo(f);
            if(JudgeYellowPicture.isYellow(baseUrl+fileName)){
                f.delete();
                return false;
            }
            return true;
            //返回提示信息
        } catch (Exception e) {
            e.printStackTrace();
           return false;
        }
    }
}
