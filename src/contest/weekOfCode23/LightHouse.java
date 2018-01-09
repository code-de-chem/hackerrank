package contest.weekOfCode23;

import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class LightHouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = in.next();
            for (int j = 0; j < n; j++) {
                char c = temp.charAt(j);
                if (c == '.') {
                    grid[i][j] = 1;ans[i][j]=0;
                } else {
                    grid[i][j] = 0;ans[i][j]=-1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    for(int k=0;i+k<n&&j+k<n&&i-k>=0&&j-k>=0;k++){
                        //System.out.println("i= "+i+"j= "+j+"k= "+k);
                        boolean flag = true;
                        for(int l = i-k;l<=i+k;l++){
                            for(int m=j-k;m<=j+k;m++){
                                int dist = distance(i, j, l, m);
                          //      System.out.println(i+" "+j+" "+l+" "+m+" "+dist+" ");
                                if(dist==k){
                                    if(grid[l][m]==0){
                                        flag = false;
                                    }
                                }
                            }
                        }
                        if(flag){
                            ans[i][j]=k;
                        }
                        //System.out.println("");
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               // System.out.print(ans[i][j]+"\t");
                max = Math.max(max, ans[i][j]);
            }
          //  System.out.println("");
        }
        System.out.println(max);
    }
    static int distance(int x1, int y1, int x2, int y2){
        double ans = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        return (int)Math.ceil(ans);
    }
}
