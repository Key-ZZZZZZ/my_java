package com.test;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int bai = i / 100 ;
        int shi = i / 10 % 10;
        int ge = i % 10;

        System.out.println(bai +","+ shi+ "," + ge);
    }
}
