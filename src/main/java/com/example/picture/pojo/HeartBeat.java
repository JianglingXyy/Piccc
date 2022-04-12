package com.example.picture.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//存储uid和ip
public class HeartBeat {
    private  int uid;
    private  String ip;
}
