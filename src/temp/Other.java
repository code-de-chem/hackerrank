package temp;

import java.util.*;

/**
 *
 * @author Kewl
 */
public class Other {

    public static void main(String[] args) throws java.lang.Exception {
        int n = 50;
        int r = 25;
        int p = 17;

        System.out.println("Value of " + n + "C" + r + " % " + p + " is " + nCrModpLucas(n, r, p));
    }

    static int sweetness(int[] arr) {
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;
        int n = max(arr) + 1;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, MAX);
        Arrays.fill(right, MIN);

        for (int i = 0; i < arr.length; i++) {
            left[arr[i]] = left[arr[i]] > i ? i : left[arr[i]];
            right[arr[i]] = right[arr[i]] > i ? right[arr[i]] : i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] != MAX && right[i] != MIN) {
                ans += Math.abs(right[i] - left[i]);
            }
        }
        return ans;
    }

    static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        return max;
    }

    static int minCost(int n, int[] from, int[] to, int[] weight, int start, int end, int w) {
        final int MAX = Integer.MAX_VALUE;
        start--;
        end--;
        int[] dE = new int[n];
        int[] dS = new int[n];

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            dE[i] = MAX;
            dS[i] = MAX;
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
            grid[i][i] = 0;
        }
        for (int i = 0; i < from.length; i++) {
            grid[from[i] - 1][to[i] - 1] = weight[i];
            grid[to[i] - 1][from[i] - 1] = weight[i];
        }

        List<Integer> list = new LinkedList<>();
        boolean[] v = new boolean[n];
        dS[start] = 0;
        list.add(start);
        while (!list.isEmpty()) {
            int temp = list.remove(0);
            v[temp] = true;
            for (int i = 0; i < n; i++) {
                if (grid[temp][i] != -1) {
                    if (!v[i]) {
                        list.add(i);
                    }
                    dS[i] = Math.min(dS[i] - grid[temp][i], dS[temp]) + grid[temp][i];
                }
            }
        }

        list = new LinkedList<>();
        v = new boolean[n];
        dE[end] = 0;
        list.add(end);
        while (!list.isEmpty()) {
            int temp = list.remove(0);
            v[temp] = true;
            for (int i = 0; i < n; i++) {
                if (grid[temp][i] != -1) {
                    if (!v[i]) {
                        list.add(i);
                    }
                    dE[i] = Math.min(dE[i] - grid[temp][i], dE[temp]) + grid[temp][i];
                }
            }
        }

        int ans = dS[end - 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    if (i == start && dE[j] != MAX) {
                        ans = Math.min(ans, w + dE[j]);
                    } else if (j == end && dS[i] != MAX) {
                        ans = Math.min(ans, dS[i] + w);
                    } else if (dE[j] != MAX && dS[i] != MAX) {
                        ans = Math.min(ans, dS[i] + w + dE[j]);
                    }
                }
            }
        }
        return ans;

    }

    static int nCrModpDP(long n, int r, int p) {
        // The array C is going to store last row of
        // pascal triangle at the end. And last entry
        // of last row is nCr
        int[] C = new int[r + 1];

        C[0] = 1; // Top row of Pascal Triangle

        // One by constructs remaining rows of Pascal
        // Triangle from top to bottom
        for (int i = 1; i <= n; i++) {
            // Fill entries of current row using previous
            // row values
            for (int j = Math.min(i, r); j > 0; j--) // nCj = (n-1)Cj + (n-1)C(j-1);
            {
                C[j] = (C[j] + C[j - 1]) % p;
            }
        }
        return C[r];
    }

    static int nCrModpLucas(long n, int r, int p) {
// Base case
        if (r == 0) {
            return 1;
        }

// Compute last digits of n and r in base p
        long ni = n % p;
        int ri = r % p;

// Compute result for last digits computed above, and
// for remaining digits. Multiply the two results and
// compute the result of multiplication in modulo p.
        return (nCrModpLucas(n / p, r / p, p) * // Last digits of n and r
                nCrModpDP(ni, ri, p)) % p; // Remaining digits
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder("");
        int n = num1.length();
        int m = num2.length();
        int carry = 0, sum;
        int i, j;
        for (i = n - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {
            int a = Integer.parseInt("" + num1.charAt(i));
            int b = Integer.parseInt("" + num2.charAt(j));
            //System.out.println(a+" "+b);
            sum = carry + a + b;
            ans.append("" + (sum % 10));
            carry = sum / 10;
        }
        if (i >= 0) {
            for (; i >= 0; i--) {
                int a = Integer.parseInt("" + num1.charAt(i));
                sum = carry + a;
                ans.append("" + (sum % 10));
                carry = sum / 10;
            }
        }
        if (j >= 0) {
            for (; j >= 0; j--) {
                int a = Integer.parseInt("" + num2.charAt(j));
                sum = carry + a;
                ans.append("" + (sum % 10));
                carry = sum / 10;
            }
        }
        if (carry != 0) {
            ans.append("" + carry);
        }
        return ans.reverse().toString();
    }
}
