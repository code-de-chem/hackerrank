package algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class PlayGame {
    static int[] array;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i <t; i++){
            int n = in.nextInt();
            array = new int[n];
            for(int j =n-1;j>=0;j--){
                array[j]=in.nextInt();
            }
            long[] sum = new long[n+1];
            sum[0] = 0;
            for(int j=1;j<=n;j++)
                sum[j]=sum[j-1]+array[j-1];
            prettyPrint(sum,"Sum array");
            long[] dp = new long[n+1];
            dp[0] = 0;
            dp[1] = array[0];
            dp[2] = array[0]+array[1];
            dp[3] = array[0]+array[1]+array[2];
            for(int j=4;j<=n;j++){
                dp[j] = Math.max(Integer.MIN_VALUE, sum[j-1]-dp[j-1]+array[j-1]);
                dp[j] = Math.max(dp[j], sum[j-2]-dp[j-2]+array[j-1]+array[j-2]);
                dp[j] = Math.max(dp[j], sum[j-3]-dp[j-3]+array[j-1]+array[j-2]+array[j-3]);
            }
            prettyPrint(dp,"dp array");
            System.out.println(dp[n]);
        }
    }
    
    public static void prettyPrint(long[] array,String text){
        System.out.println(text);
        for(long temp:array)
            System.out.print(temp+" ");
        System.out.println();
    }
}
