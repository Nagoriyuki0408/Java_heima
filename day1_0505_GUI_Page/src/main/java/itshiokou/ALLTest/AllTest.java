package itshiokou.ALLTest;
import java.util.Scanner;

public class AllTest {
    public static void main(String args[]){

        int age;
        String gender;
        double height, weight;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your age:");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Please enter your gender:");
        gender = scanner.nextLine();
        System.out.println("Please enter your height:");
        height = scanner.nextDouble();
        System.out.println("Please enter your weight:");
        weight = scanner.nextDouble();
        double BMI=weight/(height*height);
        double BMR=66+13.7*weight+5*height-6.8*age;
        System.out.println("Your BMI is: "+BMI);
        System.out.println("Your BMR is: "+BMR);

    }
}