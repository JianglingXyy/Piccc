package com.example.picture.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private T result;
    private int code;
    private String msg;

    public static<T> Response<T> ResponseOK(T object){
        Response<T> response = new Response<T>();
        response.setCode(200);
        response.setResult(object);
        return response;
    }
    public static<T> Response<T> ResponseOK(){
        Response<T> response = new Response<T>();
        response.setCode(200);
        return response;
    }
    public static<T> Response<T> failResponse(int code){
        Response<T> response = new Response<T>();
        response.setResult(null);
        response.setCode(code);
        return response;
    }


    public static <T>Response<T> failResponse(){
        Response<T> response = new Response<T>();
        response.setResult(null);
        response.setCode(400);
        return response;
    }



    public static<T> Response<T>failResponse(String msg){
        Response<T> response = new Response<T>();
        response.setResult(null);
        response.setCode(400);
        response.setMsg(msg);
        return response;
    }
}
