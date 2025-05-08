package String;

public class StringDemo1 {
    public static void main(String[] args) {
         String s1="Hello World";
         System.out.println(s1);
         //  创建字符串对象
         String s2=new String("hello");
         System.out.println(s2);
         // 创建空字符串对象
         String s3=new String();
         System.out.println(s3);
         // 创建字符串对象
         char[] chars={'a','b','c'};
         String s4=new String(chars);
         System.out.println(s4);
         // 创建字符串对象

         byte[] bytes={97,98,99};
         String s5=new String(bytes);
         System.out.println(s5);
         // 创建字符串对象

         System.out.println("------");
         String t1="abc";
         String t2="abc";
         System.out.println(t1==t2);
         //  创建字符串对象

    }

}
