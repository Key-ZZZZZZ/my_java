package com.test;

import java.util.Scanner;

public class MoneyCapiticalNumber {
    public static void main(String[] args) {

        //输入一个数字，并判别合法
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to be capitical: ");
        int num = sc.nextInt();
        if (num < 0 || num > 99999){
            System.out.println("Invalid number");
        }

//        获取每一位的数字将其转换成大写
        String result = "";
        while (true){

            int ge = num % 10;
            result = toChinese(ge) + result;

            num = num / 10;

            if(num == 0){
                break;
            }

        }
//        在前面补齐0，补齐7位
        int count = 7 - result.length();
        for (int i = 0; i < count; i++) {
            result = "零" + result;
        }
        String newResult = "";
        String[] unit = {"佰","拾","万","仟","佰","拾","元"};
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            newResult = newResult + c + unit[i];
        }
        System.out.println(newResult);

    }
//    将数字转换成大写
    public static String toChinese(int num){
        String[] arr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

        String result = "";

        return arr[num];
    }
}
