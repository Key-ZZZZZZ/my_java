package com.test;

public class Test19 {
    public static void main(String[] args){

        int[][] arr = new int[3][3];

        arr[0][0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
