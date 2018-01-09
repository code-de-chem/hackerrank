package algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class MaxSubArray {
    
    static Scanner scanner;
    static int[] input;
    static int n;
    static long sumCont, sumNonCont;
    
    public static void main(String[] args){
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            n = scanner.nextInt();
            input = new int[n];
            for(int j = 0; j < n; j++){
                input[j] = scanner.nextInt();
            }
            sumCont = sumContinous();
            sumNonCont = sumNonContinous();
            java.util.Arrays.sort(input);
            if(sumCont == 0)
                sumCont = input[n-1];
            if(sumNonCont == 0)
                sumNonCont = input[n-1];
            System.out.println(sumCont + " " + sumNonCont);
        }
    }
    
    static long sumContinous(){
        long sumSoFar =0, sumEndingHere = 0;
        for(int i = 0; i < n; i++){

            sumEndingHere += input[i];

            if(sumEndingHere > sumSoFar)
                sumSoFar = sumEndingHere;

            if(sumEndingHere < 0)
                sumEndingHere = 0;
        }
    
        return sumSoFar;
    }
        
    static long sumNonContinous(){
        long sumSoFar =0;
        for(int i =0; i < n; i++){
            if(input[i] > 0){
                sumSoFar += input[i];
            }
        }
        return sumSoFar;
    }
}
