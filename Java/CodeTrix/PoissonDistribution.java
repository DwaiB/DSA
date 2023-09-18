package Java.CodeTrix;

import java.text.DecimalFormat;
import java.util.Scanner;

class PoissonDistribution{
    enum SIGN{
        GREATER,
        LOWER,
        EQUALS
    }
    double lamda;

    public double Probability(int X,SIGN sign){
        if(sign == SIGN.EQUALS){
            return equation(X);
        }else if(sign == SIGN.LOWER){
            return lowerEquation(X);
        }else{
            return 1 - lowerEquation(X);
        }
    }
    public int factorial(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return n* factorial(n-1);
    }
    public double equation(int k){
        double e = 2.71828;
        return (Math.pow(e,-lamda)*(lamda*k))/factorial(k);
    }
    public double lowerEquation(int X){
        double P = 0;
        for(int i = 0; i <X;i++){
            double value = format(equation(i));
            System.out.println("Value of "+i+" = "+value);
            P += value;
        }
        return P;
    }
    public double format(double data){
        DecimalFormat df = new DecimalFormat("#.###");
        return Double.parseDouble(df.format(data));
    }
    public static void main(String[] args) {
        PoissonDistribution pr = new PoissonDistribution();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Equation \n1.GREATER\t2.LOWER\n3.EQUALS\t0.EXIT");
            int choice = sc.nextInt();
            if(choice == 0) break;
            System.out.println("Enter Average Case ");
            pr.lamda = sc.nextInt();
            System.out.println("Enter Check value X ");
            int X = sc.nextInt();
            SIGN s = ((choice == 1)?SIGN.GREATER:(choice == 2)?SIGN.LOWER:SIGN.EQUALS);
            double data = pr.Probability(X,s);
            System.out.println("Probability of "+X+" being "+s+" = "+data);
        }
        sc.close();
    }
}