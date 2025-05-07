package itshiokou;
import java.util.Random;
import java.util.Scanner;
public class trialcode {
    public static String Generatecaptcha(int captchaLength ){
        String characters="1234567890qwertyuiopasdfghjklzxcvbnm";
        StringBuilder captcha= new StringBuilder();
        Random random =new Random();
        for(int i=0;i<captchaLength;i++){
            int index=random.nextInt(characters.length());
            captcha.append(characters.charAt(index));
        }
        return captcha.toString();
    }
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);//建立一个Scanner参数，用于读取输入
        int length=6;
        String captcha=Generatecaptcha(length);//生成一串验证码
        System.out.println("Please enter th captcha:"+captcha);
        String userAnswer=scanner.nextLine();
            if(userAnswer!=captcha) System.out.println("Correct");
            else System.out.println("Wrong,please enter again");
    }
}
