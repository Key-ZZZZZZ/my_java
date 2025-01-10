package com.test;

public class Test12 {
    public static void main(String[] args){
        int count = 0;

        for(int i = 101;i <= 200;i++){
            boolean flag = true;
            for(int j = 2;j < i;j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }

            if(flag){
                count ++;
                System.out.println(i +"是质数");
            }

        }
        System.out.println(count);


    }
}
