package com.test;

import java.util.Scanner;

public class Test14 {
    public static void main(String[] args) {
        int[] arr = getScore();
        int max = getMAx(arr);
        int min = getMin(arr);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        float avg = (float) (getSum(arr)-max-min) / (arr.length-2);
        System.out.println("平均分：" + avg);

        printArr(arr);
    }
    public static int[] getScore(){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; ) {
            System.out.println("请输入一个分数：");
            int num = sc.nextInt();
            if(num >= 0 && num <= 100){
                arr[i] = num;
                i++;
            }else {
                System.out.println("输入的分数有误，请重新输入");
            }
        }
        return arr;
    }
    public static int getMAx(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int getMin(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static int getSum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
