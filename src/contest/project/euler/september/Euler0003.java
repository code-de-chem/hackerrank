package contest.project.euler.september;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 * 
 * Largest prime factor of a given number N
 */
public class Euler0003 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        BigInteger temp = BigInteger.valueOf(2);
        BigInteger max;
        for(int i = 0; i < t; i++){
            long n = in.nextLong();
            while(n % 2 == 0){
                n = n/2;
            }
            if(n==1)
                System.out.println("2");
            else{
                int j = 3;
                while(j <= Math.sqrt(n)){
                    if(n % j == 0){
                        n = n/j;
                        j = 3;
                        continue;
                    }
                    j += 2;
                }
                if(n>2)
                    System.out.println(n);
                else 
                    System.out.println(j);
            }
            
        }
        
    }
    
    
}
