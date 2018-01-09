package contest.sears;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class ModifiedFibonacci {

    static Map<Long, BigInteger> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(0L, BigInteger.ONE);
        map.put(1L, BigInteger.ONE);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        long[] array = new long[n];
        long[] sum = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextLong();
        }
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                sum[j] += array[j + i];
                ans.add(fib(sum[j] % m).mod(BigInteger.valueOf(m)));
            }
        }
        System.out.println(ans);
    }

    static BigInteger fib(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            BigInteger a = fib(n - 1);
            BigInteger b = fib(n-2);
            map.put(n,a.add(b).add(BigInteger.ONE));
        }
        return map.get(n);
    }
}
