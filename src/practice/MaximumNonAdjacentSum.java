package practice;

import java.util.Scanner;

/**
 *
 * @author Kewl
 *
 * Given an array of positive numbers, find the maximum sum of a subsequence
 * with the constraint that no 2 numbers in the sequence should be adjacent in
 * the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7
 * should return 15 (sum of 3, 5 and 7).
 *
 */
public class MaximumNonAdjacentSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i <n;i++){
            array[i] = in.nextInt();
        }
        System.out.println(value(array));
    }
    static long value(int[] array){
        if(array.length==1)return array[0];
        if(array.length == 2)return Math.max(array[0], array[1]);
        long[] sum = new long[array.length];
        sum[0] = Math.max(0, array[0]);
        sum[1] = Math.max(0, array[1]);
        long max = Math.max(sum[0], sum[1]);
        for(int i = 2; i < array.length; i++){
            sum[i] = Math.max(sum[i-1],sum[i-2]+array[i]);
            max = Math.max(max, sum[i]);
        }
        if(max == 0 ){
            max = Long.MAX_VALUE;
            for(int i : array)max = Math.max(max, i);
        }
        return max;
    }
}
