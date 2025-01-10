package com.test;

import java.util.Random;
import java.util.Scanner;

public class Test06 {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(10);
        Scanner sc = new Scanner(System.in);

        while (true){
            int a = sc.nextInt();
            if (a == num){
                System.out.println("猜对了");
                break;
            }else if (a > num){
                System.out.println("猜大了");
//                a=sc.nextInt();
            }else {
                System.out.println("猜小了");
//                a=sc.nextInt();
            }

        }

    }
}
