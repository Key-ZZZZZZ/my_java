package com.test;

import java.util.Random;

/*
抽奖
 */
public class Test16 {
    public static void main(String[] args){

        int[] newArr = {2,588,888,1000,10000};
        int[] newArr2 = new int[newArr.length];
        Random r = new Random();
        for(int i=0;i<5;){
            //获取随机索引
            int randomIndex = r.nextInt(newArr.length);
            //获取奖项
            int prize = newArr[randomIndex];
            //判断是否重复
            boolean flag = contains(newArr2,newArr[randomIndex]);
            if(!flag){
                newArr2[i] = prize;
                i++;

            }
        }

        for (int i = 0; i < newArr2.length; i++) {
            System.out.print(newArr2[i]+" ");
        }



    }
    public static boolean contains(int[] arr,int number){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number){
                return true;
            }
        }
        return false;
    }
}
