package com.test;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = sc.nextInt();
        boolean flag = true;
        for(int i = 2; i< Math.sqrt(num); i++){
            if(num % i == 0){
//                System.out.println(num+"不是质数");
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println(num+"是质数");
        }else {
            System.out.println(num+"不是质数");
        }

    }
}
