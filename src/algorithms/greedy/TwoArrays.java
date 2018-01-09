package algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class TwoArrays {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                long k = in.nextLong();
                long[] a = new long[n];
                long[] b = new long[n];
                ///ArrayList<Long> b = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    a[j] = in.nextLong();
                }for (int j = 0; j < n; j++) {
                    b[j] = in.nextLong();//b.add(in.nextLong());
                }
                Arrays.sort(a, 0, n);
                Arrays.sort(b, 0, n);
                //Collections.sort(b);
                boolean flag = false;
                for (int j = 0; j < n; j++) {
                    if(a[j]+b[n-j-1]<k){
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
