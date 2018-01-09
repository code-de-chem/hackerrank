package contest.project.euler;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * @author Saurabh Singh
 * Multiples of 3 and 5
 * using BigInteger and Arithmetic Progression 
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        BigInteger sum3 = BigInteger.ZERO;
        BigInteger sum5 = BigInteger.ZERO;
        BigInteger sum15 = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < t; i++){
            long n = scanner.nextLong();
            long temp = (n-1)/3;
            sum3 = sum3.add(BigInteger.valueOf((2*3+(temp-1)*3)));
            sum3 = sum3.multiply(BigInteger.valueOf(temp));
            sum3 = sum3.divide(BigInteger.valueOf(2));
            temp = (n-1)/5;
            sum5 = sum5.add(BigInteger.valueOf((2*5+(temp-1)*5)));
            sum5 = sum5.multiply(BigInteger.valueOf(temp));
            sum5 = sum5.divide(BigInteger.valueOf(2));
            temp = (n-1)/15;
            sum15 = sum15.add(BigInteger.valueOf((2*15+(temp-1)*15)));
            sum15 = sum15.multiply(BigInteger.valueOf(temp));
            sum15 = sum15.divide(BigInteger.valueOf(2));
            sum = sum.add(sum3);
            sum = sum.add(sum5);
            sum = sum.subtract(sum15);
            System.out.println(sum);
            sum = BigInteger.ZERO;
            sum3 = BigInteger.ZERO;
            sum5 = BigInteger.ZERO;
            sum15 = BigInteger.ZERO;
        }
    }
    
}
