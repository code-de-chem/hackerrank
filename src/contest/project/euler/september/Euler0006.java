package contest.project.euler.september;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class Euler0006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            BigInteger squaredsum = BigInteger.valueOf(n);
            squaredsum = squaredsum.multiply(BigInteger.valueOf(n+1));
            squaredsum = squaredsum.multiply(BigInteger.valueOf(2*n+1));
            squaredsum = squaredsum.divide(BigInteger.valueOf(6));
            
            BigInteger sumsquared = BigInteger.valueOf(n);
            sumsquared = sumsquared.multiply(BigInteger.valueOf(n+1));
            sumsquared = sumsquared.divide(BigInteger.valueOf(2));
            sumsquared = sumsquared.multiply(sumsquared);
            System.out.println(sumsquared.subtract(squaredsum));
        }
    }
}
