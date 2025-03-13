package com.manager2;

import com.manger.Manager;

import java.util.ArrayList;
import java.util.Random;
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

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        boolean flag = contains(list,username);
        if(!flag){
            System.out.println("用户名不存在，请重新输入");
            return;
        }
        System.out.println("请输入身份证号：");
        String personID = sc.next();
        System.out.println("请输入手机号：");
        String password = sc.next();
        //判断身份证号和手机号是否一致
        int index = getIndex(list,username);
        User u = list.get(index);
        if (!((u.getPersonID().equals(personID)) && (u.getPhoneNumber().equals(password)))){
            System.out.println("身份证号和手机号不一致，不能修改密码");
            return;
        }
        String newPassword;
        while (true){
            System.out.println("请输入新密码：");
            newPassword = sc.next();
            System.out.println("请再次输入新密码：");
            String newPassword2 = sc.next();
            if (!newPassword.equals(newPassword2)){
                System.out.println("两次密码不一致，请重新输入");
                continue;
            }else {
                System.out.println("两次密码一致，密码修改成功");

                break;
            }
        }
        u.setPassword(newPassword);

        System.out.println("修改密码成功");
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
            if (!(num >= 0 && num <= 9)){
                return false;
            }


        }
        return true;
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

    private static void register(ArrayList<User> list) {
        //键盘录入用户名
        Scanner sc = new Scanner(System.in);
        String username;
        while (true){
            System.out.println("请输入用户名：");
            username = sc.next();

            //先校验再判断是否唯一
            boolean flag1 = checkUsername(username);
            if (!flag1){
                System.out.println("用户名不合法，请重新输入");
            }
            //校验用户名是否唯一
            boolean flag2 = contains(list,username);
            if (flag2){
                System.out.println("用户名已存在，请重新输入");
                continue;
            }else {
                System.out.println(username+"用户名可用");
                break;
            }

        }

//        键盘录入密码
        String password;
        while (true){
            System.out.println("请输入密码：");
            password = sc.next();
            System.out.println("请再次输入密码：");
            String password2 = sc.next();
            if (!(password.equals(password2))){
                System.out.println("两次密码不一致，请重新输入");
                continue;
            }else {
                System.out.println("两次密码一致，密码输入成功");
                break;
            }




        }
        //        键盘录入身份证号
        //3.键盘录入身份证号码
        String personID;
        while (true) {
            System.out.println("请输入身份证号码");
            personID = sc.next();
            boolean flag = checkPersonID(personID);
            if (flag) {
                System.out.println("身份证号码满足要求");
                break;
            } else {
                System.out.println("身份证号码格式有误，请重新输入");
                continue;
            }
        }



//        键盘录入手机号码
        String phoneNumber;
        while (true){
            System.out.println("请输入手机号码：");
            phoneNumber = sc.next();
            boolean flag4 = checkPhoneNumber(phoneNumber);
            if (!flag4){
                System.out.println("手机号码格式有误，请重新输入");
                continue;
            }else {
                System.out.println("手机号码格式正确");
                break;
            }
        }

        User u = new User(username,password,personID,phoneNumber);
        list.add(u);


        System.out.println("注册成功");

        printUser(list);



    }

    private static void login(ArrayList<User> list) {
        //键盘录入用户名
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String username = sc.next();
            //判断用户名是否存在
            boolean flag = checkUsername(username);
            if (!flag){
                System.out.println("用户名"+username+"未注册，请先注册！");
                return;
            }

            System.out.println("请输入密码：");
            String password = sc.next();

            while (true){
                String rightCode = getCode();
                System.out.println("验证码："+rightCode);
                System.out.println("请输入验证码：");
                String code = sc.next();
                if (!rightCode.equals(code)){
                    System.out.println("验证码错误，请重新输入");
                    continue;
                }else {
                    System.out.println("验证码正确");
                    break;
                }
            }

            User u = new User(username,password,null,null);
            //定义一个方法来验证学生信息
            boolean result = checkUserInfo(list,u);
            if (result){
                System.out.println("登录成功，欢迎"+username);
                Manager manager = new Manager();
                manager.start();
                break;

            }else {
                System.out.println("登录失败，用户名或密码错误");
                if (i == 2){
                    System.out.println("您的登录次数已达上限，请明天再来");
                    return;
                }else {
                    System.out.println("您还有"+(2-i)+"次机会");
                }
            }
        }

    }

    private static boolean checkUserInfo(ArrayList<User> list, User u) {
        //遍历集合，查看再用户列表中是否存在
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String name = user.getUsername();
            String password = user.getPassword();
            if (name.equals(u.getUsername()) && password.equals(u.getPassword())){
                return true;
            }
        }
        return false;
    }

    private static String getCode() {
        //创建一个集合存储所有的大写和小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        //创建一个集合存储验证码
        StringBuilder codeList = new StringBuilder();
        //随机获取4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //获取随即索引
            int index = r.nextInt(list.size());
            //获取字符
            char c = list.get(index);
            codeList.append(c);
        }

        //随机获取一个数字
        int number = r.nextInt(10);
        codeList.append(number);
        //打乱验证码
        for (int i = 0; i < codeList.length(); i++) {
            int index = r.nextInt(codeList.length());
            char c = codeList.charAt(i);
            //修改第i个位置的字符为第index位置的字符
            codeList.setCharAt(i,codeList.charAt(index));
            //修改第index位置的字符为第i位置的字符
            codeList.setCharAt(index,c);
        }

        return codeList.toString();


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

    //打印所有用户
    public static void printUser(ArrayList<User> list){
      if (list.size() == 0){
          System.out.println("无用户信息，请先添加信息再查询");
          return;
      }
        System.out.println("用户名\t\t密码\t\t身份证号\t\t手机号");
      for (int i = 0; i < list.size(); i++) {
          User user = list.get(i);
          System.out.println(user.getUsername()+"\t\t"+user.getPassword()+"\t\t"+user.getPersonID()+"\t\t"+user.getPhoneNumber());
      }
    }


}
