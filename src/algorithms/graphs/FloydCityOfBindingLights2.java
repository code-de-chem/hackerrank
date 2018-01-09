package algorithms.graphs;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class FloydCityOfBindingLights2 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[][] dist = new long[n+1][n+1];
        for(int i = 0; i <=n; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int i = 0; i < m; i++){
            dist[in.nextInt()][in.nextInt()] = in.nextInt();
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j]-dist[k][j], dist[i][k])+dist[k][j];
                }
            }
        }
        
        int q = in.nextInt();
        for(int i = 0; i <q; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(dist[a][b]==Long.MAX_VALUE?-1:dist[a][b]);
        }
    }
}
