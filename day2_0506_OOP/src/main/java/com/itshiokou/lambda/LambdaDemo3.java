package com.itshiokou.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo3 {
    //静态方法引用，如果表达式调用静态方法，且前后参数形式一直，可以使用静态方法引用
    public static void test() {
         Student[] students = {
                new Student("张三", 18, 100, "男"),
                new Student("李四", 19, 90, "男"),
                new Student("王五", 20, 80, "男"),
                new Student("赵六", 21, 70, "男"),
                new Student("孙七", 22, 60, "男"),
        };
         Arrays.sort(students,new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });
//         Arrays.sort(students,(o1, o2)-> o1.getAge()-o2.getAge());
//
//        Arrays.sort(students,(o1,o2)->Student.compareBuAge(o1, o2));
//
         Arrays.sort(students, Student::compareBuAge);//静态方法引用
         for (Student student : students) {
             System.out.println(student.name);
         }

    }
    public static void main(String[] args) {
        test();
    }

}
