package com.example.picture.service.Pic;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
      boolean savePicture(String baseUrl,String name, MultipartFile multipartFile);
}
