package com.test;

import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            if(i*i == a){
                System.out.println(i+"是"+a+"的平方根");
                break;
            }else if (i * i > a) {
                System.out.println((i-1)+"是"+a+"的平方根");
                break;
            }
        }

    }
}
