package contest.project.euler.september;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 * 
 * sum of even numbers of Fibonacci series starting 
 * with 1 and 2 and less than n
 */
public class Euler0002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            long temp = in.nextLong();
            long a = 2L, b = 8L, c = 0L;
            BigInteger sum = BigInteger.ZERO;
            sum = sum.add(BigInteger.valueOf(10));
            while((a+4*b) <= temp){
                c = a + 4*b;
                a = b;
                b = c;
                sum = sum.add(BigInteger.valueOf(b));
            }
            System.out.println(sum);
            
        }
    }
}
