package com.manager2;

import java.util.ArrayList;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1 登录 2 注册 3 忘记密码");

            String choice = sc.next();
            switch (choice){
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                }
                default -> System.out.println("输入错误,没有这个选项");


            }

        }

    }

    private static void forgetPassword(ArrayList<User> list) {
        System.out.println("忘记密码");
    }

    private static void register(ArrayList<User> list) {
        //键盘录入用户名
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入用户名：");
            String username = sc.next();

            //先校验再判断是否唯一
            boolean flag1 = checkUsername(username);
            if (!flag1){
                System.out.println("用户名不合法，请重新输入");
            }
            //校验用户名是否唯一
            boolean flag2 = contains(list,username);
            if (!flag2){
                System.out.println("用户名已存在，请重新输入");
            }else {
                System.out.println(username+"用户名可用");
                break;
            }
        }

//        键盘录入密码
        while (true){
            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("请再次输入密码：");
            String password2 = sc.next();
            if (!(password.equals(password2))){
                System.out.println("两次密码不一致，请重新输入");
                continue;
            }else {
                System.out.println("两次密码一致，密码输入成功");
            }



        }


        while (true){
            System.out.println("请输入身份证号");
            String personID = sc.next();
            boolean flag3 = checkPersonID(personID);
            if (!flag3){
                System.out.println("身份证号错误，请重新输入");
                continue;
            }else {
                System.out.println("身份证号正确");
                break;
            }
        }


//        键盘录入手机号码
        while (true){
            System.out.println("请输入手机号码：");
            String phoneNumber = sc.next();
            boolean flag4 = checkPhoneNumber(phoneNumber);
            if (!flag4){
                System.out.println("手机号码格式有误，请重新输入");
                continue;
            }else {
                System.out.println("手机号码格式正确");
                break;
            }
        }


        System.out.println("注册成功");



    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        int len = phoneNumber.length();
        if (len != 11){
            return false;
        }
        if (phoneNumber.startsWith("0")){
            return false;
        }
        for (int i = 0; i < len; i++) {
            char ch = phoneNumber.charAt(i);
            int num = ch - '0';
            if (num > 9){
                return false;
            }else {
                return true;
            }
        }
    }

    public static boolean checkPersonID(String personID) {

        //长度为18位
        if (personID.length() != 18){
            return false;
        }
        //不能以0为开头
        if (personID.charAt(0) == '0'){
            return false;
        }
        //前17位，必须都是数字
        for (int i = 0; i < personID.length()-1; i++) {
            char ch = personID.charAt(i);
            if (!(ch >= '0' && ch <= '9')){
                return false;
            }

        }
        //最为一位可以是数字，也可以是大写X或小写x
        char endChar = personID.charAt(personID.length()-1);
        if (!(endChar >= '0' && endChar <= '9') && !(endChar == 'x' || endChar == 'X')){
            return false;

        }else {
            return true;

        }
    }

    private static void login(ArrayList<User> list) {
        System.out.println("登录");
    }

    //校验方法
//    1，用户名需要满足以下要求：
//    验证要求：
//    用户名唯一
//    用户名长度必须在3~15位之间
//    只能是字母加数字的组合，但是不能是纯数字
    public static boolean checkUsername(String username){
        int len = username.length();
//        用户名长度必须在3~15位之间
        if(len < 3 || len > 15){
            return false;
        }
//        只能是字母加数字的组合，
        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))){
                return false;

            }
        }
        //        但是不能是纯数字
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                count++;
                break;
            }
        }
        return count > 0;
    }

    //查看用户是否存在
    public static boolean contains(ArrayList<User> list,String username){
      int count = getIndex(list,username);
      return count >= 0;
    }
    //根据用户名获取用户索引
    public static int getIndex(ArrayList<User> list,String username){
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String name = user.getUsername();
            if(name.equals(username)){
                return i;
            }

        }
        return -1;
    }
}
