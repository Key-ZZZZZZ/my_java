package com.test;

import java.util.Random;

public class Test07 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100)+1;

        }
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
//            System.out.println(arr[i]);
        }
        System.out.println(sum);
    }
}
