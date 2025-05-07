package com.itshiokou.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LambdaDemo2 {
    public static void main(String[] args) {
        //目标：用lambda表达式来简化函数接口的匿名抽象内部类
        Student[] students = {
                new Student("张三", 18, 100, "男"),
                new Student("李四", 19, 90, "男"),
                new Student("王五", 20, 80, "男"),
                new Student("赵六", 21, 70, "男"),
                new Student("孙七", 22, 60, "男"),
        };
        //按照年龄升序排序，可以调用sun公司写好的API直接对数组进行排序
//        Array.sort(students,new Comparator<Student>(){
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        })
//        lambda表达式的简化方法1
//        Array.sort(students,(Student o1, Student o2)->{
//            return o1.getAge()-o2.getAge();
//        });

//        参数类型全部都可以不写
//        如果只有一个参数，参数类型省略的同时"()"也可以省略
//        如果lambda表达式中只有一行代码，大括号可以不写，同时要省略分号，如果是return语句，也要去掉return

//        Lambda表达式的进一步简化方法
//        Array.sort(students,(o1.o2)->{
//            return o1.getAge()-o2.getAge();
//        });
        //lambda表达式的进一步简化方法

        Arrays.sort(students,(o1, o2)->o1.getAge()-o2.getAge());
        //遍历数组当中的学生对象并输出
        for (Student student : students) {
            System.out.println(student);
        }
        //逐步简化按键监听器
        JButton jb = new JButton("按钮");
//        jb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("有人点击了按钮");
//            }
//        });
//        jb.addActionListener((ActionEvent e)->{
//            System.out.println("有人点击了按钮");
//        });
//        jb.addActionListener((e)->
//                System.out.println("有人点击了按钮")
//        );
        jb.addActionListener(e->
            System.out.println("有人点击了按钮")
        );
    }
}
