package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Saurabh Singh
 */
public class coinChange {
    public static void main(String[] args) {
        int[] coins = { 2, 3, 4, 5};
        for(int sum = 1; sum<=30; sum++)
            coinChange(coins, sum);
        System.out.println("completed");
    }
    static void coinChange(int[] coins, int sum){
        Arrays.sort(coins);
        int currSum = 0;
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while(currSum <= sum && flag){
            if(currSum == sum)
                break;
            for(int i = coins.length-1;i >=0; i--){
                if(coins[i]+currSum <= sum){
                    currSum += coins[i];
                    list.add(coins[i]);
                    break;
                }
                if(i==0)
                    flag = false;
            }
        }
        if(flag)
            System.out.println(list);
        else
            System.out.println("sol not found for "+sum);
    }
} 