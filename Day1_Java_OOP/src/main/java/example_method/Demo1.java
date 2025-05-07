package example_method;

import com.itshiokou.lambda.Student;

import java.util.Arrays;

public class Demo1 {
        public static void test(){
            com.itshiokou.lambda.Student[] students = {
                    new com.itshiokou.lambda.Student("张三", 18, 100, "男"),
                    new com.itshiokou.lambda.Student("李四", 19, 90, "男"),
                    new com.itshiokou.lambda.Student("王五", 20, 80, "男"),
                    new com.itshiokou.lambda.Student("赵六", 21, 70, "男"),
                    new Student("孙七", 22, 60, "男"),
            };
            Student t=new Student();
            Arrays.sort(students, Student::compareBuAge);
            Arrays.sort(students, t::compareStudent);
            for (Student student : students) {
                System.out.println(student.name);
            }
        }
        public static void main(String[] args) {
            test();
        }
}
