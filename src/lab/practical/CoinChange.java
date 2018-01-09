package lab.practical;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class CoinChange {
    static int[] bestCoins;
    static int[] changeCoins;
    static int globalMax;
    static long changes = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        globalMax = sum;
        changeCoins = new int[sum+1];
        int n = in.nextInt();
        int[] coins = new int[n];
        bestCoins = new int[sum+1];
        for(int i = 0; i < n; i++){
            coins[i] = in.nextInt();
        }
        for(int i = 0; i <= sum; i++){
            changeCoins[i]= 0;
        }
        Arrays.sort(coins);
        System.out.println(dpChange(sum, coins));
        dpAllChange(0, coins);
        System.out.println(changes);
    }
    
    static int dpChange(int sum, int[] coins){
        bestCoins[0] = 0;
        for(int m = 1; m <= sum; m++){
            bestCoins[m] = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++){
                if(m >= coins[i] && bestCoins[m-coins[i]] + 1 < bestCoins[m]){
                    bestCoins[m] = bestCoins[m-coins[i]] + 1;
                }
            }
        }
        return bestCoins[sum];
    }
    static void dpAllChange(int sum, int[] coins){
        
        for(int i = 0; i < coins.length; i++){
            
            if(sum +coins[i] < globalMax)
                dpAllChange(sum + coins[i], coins);
            
            if(sum + coins[i] == globalMax){
                changes++;
                break;
            }
        }
        
    }
}
