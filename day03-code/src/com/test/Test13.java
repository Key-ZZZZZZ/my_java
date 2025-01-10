package com.test;

import java.util.Random;

/*
随机产生一个五位数的验证码
验证码格式：
长度为5
前四位时大写字母或小写字母
最后以为为一位数字
 */
public class Test13 {
    public static void main(String[] args){

//        //先把数据放到一个数组当中，然后使用后随机索引进行抽取
        char[] arr = new char[52];

        //将大小写字母存入数组当中
        for (int i = 0; i < arr.length; i++) {
            //添加小写字母
            if(i <= 25){
                arr[i] = (char)(97 + i);
            }else{
                arr[i] = (char)(65 + i - 26);
            }
        }
        printArray(arr);
        System.out.println();

        //从数组中随机抽取索引
        Random r = new Random();
        String result = "";
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(arr.length);
//            System.out.print(arr[randomIndex]);
            char temp = arr[randomIndex];
            result += temp;
        }
        System.out.println(result);

        //拼接数字
        int num  = r.nextInt(10);
        result += num;
        System.out.println(result);



    }
    public static void printArray(char[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+ " ");}
    }

}
