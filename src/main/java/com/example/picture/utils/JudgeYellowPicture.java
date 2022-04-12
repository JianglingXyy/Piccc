package com.example.picture.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@Slf4j
public class JudgeYellowPicture {
    public static  boolean isYellow(String path){
        try {

            String[] args = new String[] { "python", "/py/main.py",path};
            log.info(path);
            Process proc = Runtime.getRuntime().exec(args);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            String res = null;
            while ((line = in.readLine()) != null) {
                res = line;
            }
            in.close();
            proc.waitFor();
            return res.equals("True");
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }
    }

