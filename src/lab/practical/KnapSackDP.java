package lab.practical;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class KnapSackDP {
    static int[][] bag;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxWeight = in.nextInt();
        int n = in.nextInt();
        bag = new int[n+1][maxWeight+1];
        int[] weights = new int[n+1];
        int[] benefits = new int[n+1];
        for(int i = 1; i <= n; i++){
            weights[i] = in.nextInt();
            benefits[i] = in.nextInt();
        }
        weights[0] = benefits[0] = 0;
        knapSack(maxWeight, n, weights, benefits);
        System.out.println(bag[n][maxWeight]);
    }
    
    
    static void knapSack(int weight, int noItems, int[] weights, int[] benefits){
        for(int w = 0; w < weight; w++)
            bag[0][w] = 0;
        for(int i = 0; i < noItems; i++)
            bag[i][0] = 0;
        for(int i = 1; i <= noItems; i++){
            for(int w =0; w <= weight; w++){
                if(weights[i] <= w){
                    if(benefits[i]+bag[i-1][w-weights[i]] > bag[i-1][w])
                        bag[i][w] = benefits[i] + bag[i-1][w-weights[i]];
                    else
                        bag[i][w] = bag[i-1][w];
                }
                else
                    bag[i][w] = bag[i-1][w];
            }
        }
    }
}
