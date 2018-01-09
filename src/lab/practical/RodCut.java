package lab.practical;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class RodCut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int i = 0 ; i < n; i++){
            p[i] = in.nextInt();
        }
        System.out.println(cutRod(p,n));
        System.out.println(bottomUpCutRod(p,n));
    }
    /** Naive algo */
    static int cutRod(int[] p , int n){
        if( n== 0)
            return 0;
        int q = Integer.MIN_VALUE;
        for(int i = 0; i < p.length; i++){
            q = max(q,p[i]+cutRod(p,n-1));
        }
        return q;
    }
    
    /** Bottom up DP */
    static int bottomUpCutRod(int[] p, int n){
        int[] r = new int[n+1];
        r[0] = 0;
        for(int j = 1; j <= n; j++){
            int q = Integer.MIN_VALUE;
            for(int i = 1; i<= j; i++){
                q = max(q, p[i]+r[j-i]);
            }
            r[j] = q;
        }
        return r[n];
    } 
    
    
    static int max(int a, int b){
        return a > b? a:b;
    }
}
