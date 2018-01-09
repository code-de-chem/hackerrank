/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.graphs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Saurabh Singh
 */
public class FavouriteSequence {
    
    static Scanner scanner = new Scanner(System.in);
    static Double[] array;
    
    public static void main(String[] args){
        int n = scanner.nextInt();
        for(int i = 0; i<n; i++){
            array = new Double[n];
            int k = scanner.nextInt();
            for(int j=0;j<k;j++){
                init();
            }    
        }
       
        
        Arrays.sort(array);
        
        for(int i =0; i< array.length;i++){
            System.out.print(array[i].intValue()+" ");
        }
        
    }
    
    static void init(){
        double current = scanner.nextDouble();
        
        
    }
    
    // end of favouriteSequence class
}
