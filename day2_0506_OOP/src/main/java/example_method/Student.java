package example_method;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// 学生类
@DataAmount // 使用jdk.jfr.DataAmount注解，具体用途取决于JFR配置，通常用于标记数据量相关的类
@NoArgsConstructor // 使用Lombok生成无参构造函数
@AllArgsConstructor // 使用Lombok生成包含所有参数的构造函数
public class Student {
    String name; // 学生姓名
    private int age; // 学生年龄，私有属性
    private int score; // 学生分数
    private String sex; // 学生性别

    /**
     * 比较两个学生的年龄大小
     * @param s1 学生对象1
     * @param s2 学生对象2
     * @return  返回年龄差，正数表示s1比s2大，负数表示s1比s2小，0表示相等
     */
    public static int compareStudent(Student s1, Student s2) {

        return s1.getAge() - s2.getAge();
    }

    /**
     * 根据年龄比较两个学生的大小
     * @param o1 学生对象1
     * @param o2 学生对象2
     * @return 返回年龄差，正数表示o1比o2大，负数表示o1比o2小，0表示相等
     */
    public static int compareBuAge(Student o1, Student o2) {

        return o1.getAge() - o2.getAge();
    }

    /**
     * 获取学生的年龄
     * @return 返回学生的年龄
     */
    int getAge() {
        return this.age;
    }

}