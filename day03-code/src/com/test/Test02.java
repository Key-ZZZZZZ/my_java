package com.test;

public class Test02 {
    public static void main(String[] args){
        int x = 12345;
        int num = 0;
        System.out.println(x);
        while (x != 0){
            int ge = x % 10;
            x = x / 10;
            num = num * 10 + ge;
        }
        System.out.println(num);
    }
}
