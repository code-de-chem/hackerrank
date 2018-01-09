package contest.project.euler.september;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class Euler0007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        BigInteger[] primes = new BigInteger[10000];
        primes[0] = BigInteger.valueOf(2);
        int k = 1;
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            if(n <= k)
                System.out.println(primes[n-1]);
            else{
                for(int j = k; j < n; j++){
                    primes[j] = primes[j-1].nextProbablePrime();
                    k++;
                }
                System.out.println(primes[k-1]);
            }
        }
    }
}
