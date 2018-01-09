package contest.weekOfCode24;

import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class XorMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        boolean[] array = new boolean[n];
        for(int i = 0; i < n; i++){
            boolean temp;
            for(int j = 0; j < m/n; j++){
                
            }
        }
    }

    static boolean nCrEven(long n, int r, int p){
        return nCrModpLucas(n,r,p)==0;
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
}
