package com.manger;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

       while (true){
           System.out.println("----------------------欢迎来到学生管理系统-----------------------");
           System.out.println("1:添加学生");
           System.out.println("2:删除学生");
           System.out.println("3:修改学生");
           System.out.println("4:查看所有学生");
           System.out.println("5:退出");
           System.out.print("请输入你的选择:");
           Scanner scanner = new Scanner(System.in);
           int choice = scanner.nextInt();
           switch (choice) {
               case 1 -> addStudent(list);
               case 2 -> deleteStudent(list);
               case 3 -> updateStudent(list);
               case 4 -> findAllStudent(list);
               case 5 -> {
                   System.out.println("谢谢使用");
                   System.exit(0);
               }
               default -> System.out.println("没有这个选项");
           }
       }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list){
        Student s = new Student();
        Scanner sc= new Scanner(System.in);
        String id = null;

        while (true){
            System.out.print("请输入用户id:");
            id = sc.next();
            boolean flag = contains(list,id);
            if(flag){
                System.out.println("id已存在，请重新输入");
            }else {
                s.setId(id);
                break;
            }
        }

        System.out.print("请输入用户名：");
        String username = sc.next();
        s.setUsername(username);
        System.out.print("请输入密码：");
        String password = sc.next();
        s.setPassword(password);
        System.out.print("请输入年龄：");
        int age = sc.nextInt();
        s.setAge(age);

        list.add(s);

        System.out.println("添加用户"+s.getUsername()+"成功");
    }
    //删除学生
    public static void deleteStudent(ArrayList<Student> list){
        if (list.size() == 0){
            System.out.println("无学生信息，请添加后再删除");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id:");
        String id = sc.next();
        boolean flag = contains(list,id);
        if(flag){
            Student stu = list.get(getIndex(list,id));
            String delName = stu.getUsername();
            list.remove(getIndex(list,id));
            System.out.println("学生"+delName+"删除成功");

        }else {
            System.out.println("id不存在，请重新确认是否存在");
        }

    }
    //修改学生
    public static void updateStudent(ArrayList<Student> list){
        if (list.size() == 0){
            System.out.println("无学生信息，请添加后再修改");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String id = null;

        System.out.println("请输入要修改的id:");
        id = sc.next();
        boolean flag = contains(list,id);
        if(flag){
            System.out.println("请输入需要修改的用户名：");
            String username = sc.next();
            list.get(getIndex(list,id)).setUsername(username);
            System.out.println("请输入需要修改的密码：");
            String password = sc.next();
            list.get(getIndex(list,id)).setPassword(password);
            System.out.println("请输入需要修改的年龄：");
            int age = sc.nextInt();
            list.get(getIndex(list,id)).setAge(age);

        }else {
            System.out.println("id不存在，请重新确认是否存在");
        }

        System.out.println(list.get(getIndex(list,id)).getUsername()+"修改");
    }
    //查看所有学生
    public static void findAllStudent(ArrayList<Student> list){
        if (list.size() == 0){
            System.out.println("无信息，请先添加信息再查询");
            return;
        }
        System.out.println("id\t\t用户名\t\t密码\t\t年龄");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId()+"\t\t"+stu.getUsername()+"\t\t"+stu.getPassword()+"\t\t"+stu.getAge());


        }
        System.out.println("查看");
    }

    //判断id是否存在
    public static  boolean contains(ArrayList<Student> list,String id){
//        for (int i = 0; i < list.size(); i++) {
//            Student stu = list.get(i);
//            String sid = stu.getId();
//            if (sid.equals(id)){
//                return true;
//            }
//        }
//        return false;
        return getIndex(list,id) >= 0;
    }

    //根据用户的id查找索引
    public static int getIndex(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if (sid.equals(id)){
                return i;
            }
        }
        return -1;

    }
}
