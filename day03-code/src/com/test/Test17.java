package com.test;
/*
抽奖，随机打乱顺序
 */

import java.util.Random;

public class Test17 {
    public static void main(String[] args){

        int[] newArr = {2,588,888,1000,10000};
        Random r = new Random();

        for (int i = 0; i < newArr.length; i++) {
            int index = r.nextInt(newArr.length);
            int temp = newArr[i];
            newArr[i] = newArr[index];
            newArr[index] = temp;


        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }
}
