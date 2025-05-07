package itshiokou;
import java.util.Random;
import java.util.Scanner;

public class GuessCount {
//main函数
    public static void main(String arg[]){
        int guesstemp=0;
        int guessnumber=0;
        int try_number=new Random().nextInt(10)+1;
        int rightnumber=new Random().nextInt(100)+1;

        System.out.println("Please enter your anwser");
        System.out.println("The try_number is:"+try_number);
        Scanner sc=new Scanner(System.in);
        while(true){
            guessnumber++;
            if(sc.hasNext() ) {
                guesstemp = sc.nextInt();
                if (guesstemp == rightnumber) {
                    System.out.println("right");
                    break;
                } else if (guesstemp >= rightnumber)
                    System.out.println("too high");
                else if (guesstemp <= rightnumber)
                    System.out.println("too low");
            }
            else{
                System.out.println("Invalid Value");
            }
            if(guessnumber>try_number) {
                System.out.println("Failed\n");
                System.out.println(rightnumber);
                break;
            }
        }
        sc.close();
            }
}



