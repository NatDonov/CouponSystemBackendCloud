package com.jb.couponsys.utils;


import org.springframework.stereotype.Component;

@Component
public class PrintUtils {

    private int SIZE = 60;

    public void print(String content){
        int len = content.length();

        int side = (SIZE - len)/2;

        System.out.print("*".repeat(side));
        System.out.print(content);
        System.out.println("*".repeat(side));
    }
}
