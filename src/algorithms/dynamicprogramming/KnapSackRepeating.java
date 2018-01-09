package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class KnapSackRepeating {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int k = in.nextInt();
                int[] array = new int[n];
                for (int j = 0; j < n; j++) {
                    array[j] = in.nextInt();
                }
                int[] res = new int[k + 1];
                Arrays.fill(res, 0);
                for (int j = 1; j < k + 1; j++) {
                    for (int temp : array) {
                        if (j - temp >= 0) {
                            res[j] = Math.max(res[j], res[j - temp] + temp);
                        }
                    }
                }
                for (int j = k; j >= 0; j--) {
                    if (res[j] <= k) {
                        System.out.println(res[j]);
                        break;
                    }
                }
            }
        }
    }

    static void prettyPrint(int[] array) {
        for (int temp : array) {
            System.out.print(temp + " ");
        }
        System.out.println("");
    }
}
