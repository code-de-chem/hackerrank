package algorithms.bit.manipulation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class CounterGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i =0; i <t; i++){
            double n = in.nextDouble();
            boolean flag = true;
            while(n>1){
                if(!flag)
                    System.out.println("Richard");
                else
                    System.out.println("Louise");
                if(isPowerOf2(n)){
                    n -= n/2;
                    System.out.println("It is powr of 2");System.out.println("n updated to "+n);
                }
                else{
                    int m = findN(n);
                    n -= Math.pow(2, m);
                    System.out.println("It is not powr of 2");System.out.println("m= "+m);System.out.println("n updated to "+n);
                }
                flag = !flag;
            }
            if(flag)
                System.out.println("Richard");
            else
                System.out.println("Louise");
            
        }
        
    }
    private static int findN(double n){
        int counter  =0;
        while(n>1){
            n=n/2;
            counter++;
        }
        return counter-1;
    }
    private static boolean isPowerOf2(double n){
        boolean flag = false;
        while(n>1)
            n/=2;
        if(n==1)flag = true;
        return flag;
    }
}
