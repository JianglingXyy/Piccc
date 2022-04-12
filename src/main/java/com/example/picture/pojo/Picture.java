package com.example.picture.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture implements Serializable {
    private int pid;
    private  String location;
    private  int creator;
    private  int type;
    private String description;
    private  Timestamp createDate;
    private int likes;
    private int collections;
}
