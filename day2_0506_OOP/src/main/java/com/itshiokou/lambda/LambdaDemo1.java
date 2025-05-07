package com.itshiokou.lambda;

public class LambdaDemo1 {//函数式接口
    public static void main(String[] args) {
       Animal a = new Animal() {
           @Override
           public void cry() {
               System.out.println("cry");
           }
       };
       a.cry();
       System.out.println("----------------------");
//       Swim s = new Swim() {
//           @Override
//           public void swiming() {
//               System.out.println("swiming");
//           }
//       };
//        s1.swiming();
               Swim s = ()-> {
               System.out.println("swiming");
           };
        s.swiming();
// lambda只能简化函数式接口的实现
        //上下文推断出它真正的函数接口的匿名内部类

   }
}
abstract class Animal{
    public abstract void cry();
}

@FunctionalInterface//有这个声明就只有一个抽象函数类了
interface Swim{
    void swiming();
}
//函数式接口