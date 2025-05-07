package example_method;

import java.util.Arrays;
import java.util.Comparator;

public class Demo2 {
    public static void main(String[] args){
        String[] students  = {"张三","李四","王五","赵六","孙七"};
        //按照第一个字母来排序
//        Arrays.sort(students,new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);
//            }
//        });
        Arrays.sort(students,(o1,o2)->o1.compareToIgnoreCase(o2));
        Arrays.sort(students, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(students));
    }
}
