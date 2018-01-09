package algorithms.warmup;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class extra_long_factorials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger bi =  BigInteger.ONE;
        for(int i =2; i <= n; i++){
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bi);
    }
}
