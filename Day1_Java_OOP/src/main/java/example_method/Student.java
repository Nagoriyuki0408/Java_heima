package example_method;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@DataAmount
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    String name;
    private int age;
    private int score;
    private String sex;

    public static int compareStudent(Student s1,Student s2){

        return s1.getAge()-s2.getAge();
    }

    public static int compareBuAge(Student o1, Student o2) {

        return o1.getAge()-o2.getAge();
    }

    int getAge() {
        return this.age;
    }

}
