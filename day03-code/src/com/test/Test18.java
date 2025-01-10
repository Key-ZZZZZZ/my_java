package com.test;

import java.util.Random;
import java.util.Scanner;

/*
双色球问题
 */
public class Test18 {
    public static void main(String[] args){
        //生成双色球
        int[] a = createNumber();

        //用户输入的号码
        int[] b = userInput();

        for (int i= 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }
    //用户输入号码
    public static int[] userInput(){
        int[] a = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6;) {
            System.out.println("请输入第" + (i+1) + "个红球号码");
            int redNumber = sc.nextInt();
            if(redNumber >= 1 && redNumber <= 33){
                boolean flag = contains(a, redNumber);
                if(!flag){
                    a[i] = redNumber;
                    i++;
                }

            }else{
                System.out.println("您输入的红球号码有误，请重新输入");

            }

        }
        //添加用户红球
        System.out.println("请输入篮球号码");
        while (true){
            int blueNumber = sc.nextInt();
            if(blueNumber >= 1 && blueNumber <= 33){
                a[a.length-1] = blueNumber;
                break;
            }else{
                System.out.println("您输入的篮球号码有误，请重新输入");

            }
        }
        return a;

    }
    public static int[] createNumber(){
        //创建一个数组添加中奖号码
        int[] arr = new int[7];

        //随机生成6个号码加入到数组中
        Random r = new Random();
        for (int i = 0; i < 6;) {
            int num = r.nextInt(33) + 1;
            boolean flag = contains(arr, num);
            if(!flag){
                arr[i] = num;
                i++;
            }

        }
        //生成篮球号码
        int blue = r.nextInt(16) + 1;
        arr[arr.length-1] = blue;
        return arr;

    }
    public static boolean contains(int[] arr, int number){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number){
                return true;
            }
        }
        return false;
    }

}