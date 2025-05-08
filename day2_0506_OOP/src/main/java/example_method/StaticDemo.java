package example_method;

import java.util.Arrays;

public class StaticDemo {
    public static void main(String[] args){
        // 定义一个字符串数组，存储学生姓名
        String[] students  = {"张三","李四","王五","赵六","孙七"};
        // 按照第一个字母来排序

        // 使用匿名内部类实现Comparator接口进行排序 (注释掉的代码)
        // Arrays.sort(students,new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return o1.compareToIgnoreCase(o2); // 忽略大小写比较两个字符串
        //     }
        // });

        // 使用Lambda表达式实现Comparator接口进行排序
        // Arrays.sort(students,(o1,o2)->o1.compareToIgnoreCase(o2));

        // 使用方法引用进行排序，String::compareToIgnoreCase 等价于 (o1, o2) -> o1.compareToIgnoreCase(o2)
        // String::compareToIgnoreCase 是对String类的compareToIgnoreCase方法的引用。
        // 它提供了一种简洁的方式来传递一个已经存在的方法作为函数式接口的实现。
        Arrays.sort(students, String::compareToIgnoreCase);

        // 打印排序后的学生姓名数组
        System.out.println(Arrays.toString(students));
    }
}