package com.travel.utils;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/24
 * @introduction
 */
public class CheckByPattern {

    public static boolean checkEmail(String content){
        return content.matches("\\w+@\\w+\\.\\w+");
    }

    public static boolean checkPhoneNum(String content){
        return content.matches("1\\d{10}");
    }

}
