package itshiokou;
import java.util.Vector;
import java.util.Scanner;
public class Prime {
    public static Vector prime(int a, int b){
        Vector<Integer> primes = new Vector<>();
        for (int i = a; i <= b; i++) {
            if (i < 2) continue;
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args){
        int low_border,high_border;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the border");
        low_border=sc.nextInt();
        high_border=sc.nextInt();
        Vector name =new Vector();
        name=prime(low_border,high_border);
        System.out.println(name);
    }
}
