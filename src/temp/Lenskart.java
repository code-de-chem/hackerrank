package temp;

import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class Lenskart {
    public static void main(String args[] ) throws Exception {
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
		long A[] = new long[N];
		long B[] = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextLong();
        }
		for (int i = 0; i < N; i++) {
            B[i] = in.nextLong();
        }
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++){
            dp[i][i] = i;
        }
        for(int j = 1;j <N; j++){
            for(int i = j-1; i>=0; i--){
                if(A[dp[i][j-1]]>A[dp[i+1][j]]){
                    dp[i][j] =dp[i][j-1];
                }else if(A[dp[i][j-1]]==A[dp[i+1][j]]){
                    if(B[dp[i][j-1]]<=B[dp[i+1][j]]){
                        dp[i][j] = dp[i][j-1];
                    }else{
                        dp[i][j] = dp[i+1][j];
                    }
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(dp[a-1][b-1]+1);
        }
    }
}
