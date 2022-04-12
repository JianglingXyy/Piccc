package com.example.picture.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Repository
public class Collections {
    private  int uid;
    private  int pid;
    private  int status;
}
