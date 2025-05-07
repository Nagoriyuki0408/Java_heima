package itshiokou.hello;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(getVerifyCode());
    }
    //定义一个方法，帮我生成一个验证码返回
    public static String getVerifyCode(){
        //生成一个验证码
        String verifyCode = "";
        for (int i = 0; i < 4; i++) {
            //生成一个随机数，0-9
            int num = (int)(Math.random()*10);
            //把随机数拼接成字符串
            verifyCode += num;
        }
        return verifyCode;
    }

}
