package algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 * 
 */

public class Candies {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ratings = new int[n];
        for(int i = 0; i < n; i++){
            ratings[i] = in.nextInt();
        }
        
        int[] candies = new int[n];
        
        int  min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(ratings[i] < min)
                min = ratings[i];
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(ratings[i] == min){
                list.add(i);
            }
        }
        int[] totalCandies = new int[list.size()+1];
        
        
        int minIndex = 0;
        candies[minIndex] = 1;
        for(int  i = minIndex; i < n-1; i++){
            if(ratings[i+1] > ratings[i])
                candies[i+1] = candies[i]+1;
            else
                candies[i+1] = 1;
        }
        for(int i = minIndex ; i > 0 ; i--){
            if(ratings[i-1] > ratings[i])
                candies[i-1] = candies[i]+1;
            else
                candies[i-1] = 1;
        }
        long sum = 0L;
        for(int i = 0; i < n; i++){
            sum += candies[i];
            System.out.print(candies[i]+" ");
        }
        System.out.println("\n"+sum);
        
    }
    
}