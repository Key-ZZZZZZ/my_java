package com.test;

import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票原价：");
        int ticket = sc.nextInt();
        System.out.println("请输入当前月份：");
        int month = sc.nextInt();
        System.out.println("请输入当前购买的仓位 0 头等舱 1 经济舱");
        int seat = sc.nextInt();
        if(month >= 5 && month <= 10){

            if(seat == 0){
                System.out.println("头等舱优惠后价格："+ticket*0.9);
            }else if(seat == 1){
                System.out.println("经济舱优惠后价格："+ticket*0.85);
            }else{
                System.out.println("输入有误");
            }

        }else if(month >= 1 && month <= 4 || month >= 11 && month <= 12){

            if(seat == 0){
                System.out.println("头等舱优惠后价格："+ticket*0.5);
            }else if(seat == 1){
                System.out.println("经济舱优惠后价格："+ticket*0.45);
            }else{
                System.out.println("输入有误");
            }
        }else{
            System.out.println("输入有误");
        }
    }
}
