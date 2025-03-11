package com.test;

public class Test20 {
    public static void main(String[] args){

        int[][] arr = {
                {22,66,44},
                {77,33,88},
                {25,45,65},
                {11,66,99}
        };

        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + (i+1) + "个季度总营业额为"+ getSum(arr[i]));
        }

    }
    public static int getSum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
