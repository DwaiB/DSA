package Java.CodeTrix;
import java.util.Scanner;

public class primeornot{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number< 2){
            System.out.println(number);
        }
        int count = 0;
        for(int i = 2; i < number/2; i++) {
            if(number%i==0) count ++;
        }
        if(count ==0) System.out.println("Prime");
        else System.out.println("not Prime");
        sc.close();
    }
}