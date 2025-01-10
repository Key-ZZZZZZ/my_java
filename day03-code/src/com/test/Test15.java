package com.test;

import java.util.Scanner;

/*
某数字系统加密（大于0）,比如1983，采用加密方式为：
每位+5
再对10 取余
然后将所有数字反转
得到一串新数
 */
public class Test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = sc.nextInt();

        int[] arr = getArray(number);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 5;
            arr[i] = arr[i] % 10;
        }


        printArray(arr);
        System.out.println();
        System.out.println("--------------------------");
        int[] newArr = reverseArray(arr);
        int result = digital(newArr);
        System.out.println(result);




    }
    public static int[] getArray(int number){


        //将数字转换成字符串
        String s = Integer.toString(number);

        //定义一个新数组
        int[] arr = new int[s.length()];

        //将字符串每一位存储到数组当中
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int digital(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * 10 + arr[i];
        }
        return result;

    }
    public static int[] reverseArray(int[] arr) {
        for(int i = 0,j = arr.length-1;i<j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
//        printArray(arr);
        return arr;
    }

}
