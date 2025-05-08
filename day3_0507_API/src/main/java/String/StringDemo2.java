package String;

import java.util.Scanner;

public class StringDemo2 {
    public static void main(String[] args){
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2);
        //默认比较地址
        String s3=new String("abc");
        String s4=new String("abc");
        System.out.println(s3==s4);
        //放在堆内存当中
        System.out.println(s3.equals(s4));
        //用String提供的equals方法比较内容，只关心内容，不关心地址
        System.out.println("------");
        String OkloginName="admin";
        System.out.println("请输入你的登录名称：");
        Scanner scanner=new Scanner(System.in);
        String loginName=scanner.next();
        if(OkloginName.equals(loginName)){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
        System.out.println("------");
        System.out.println("请输入你的手机号码登录：");
        String phone = scanner.next();
        System.out.println("系统提示将以以下手机号进入");
        String newPhone = phone.substring(0,3)+"****"+phone.substring(7);
        System.out.println(newPhone);
    }
}
