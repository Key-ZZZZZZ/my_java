package com.test;

import java.util.Random;

public class Test09 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randNum = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randNum];
            arr[randNum] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
