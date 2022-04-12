package com.example.picture.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int uid;
    private String pwd;
    private String name;
    private int gender;
    private String mail;
    private String headIcon;
    private int subscribers;
    private int fans;
    private int like;
}
