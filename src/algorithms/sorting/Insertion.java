/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.sorting;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Saurabh Singh
 */
public class Insertion {
    
    static Vector<Integer> vector = new Vector<Integer>();
    static Object[] a;
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0;i<n;i++){
            int temp = scanner.nextInt();
            vector.add(temp);
        }
        a = vector.toArray();
        sort(a.length);
    }

    private static int less(int v, int w){ 
        int temp ;
        if(v>w)
            return 1;
        else if (v<w)
            return -1;
        else 
            return 0;
         
    }
    private static void exch(int i, int j){
        int temp = (int)a[i];
            a[i] = (int)a[j];
            a[j] = temp;
    }

    public static void sort(int n){ 
      int temp = (int)a[0];
      for(int i =1;i<n+1;i++){
          for(int j =i;j>=0;j--){
          int cmp=less((int)a[i],(int)a[j]);
            if (cmp==1){
              exch(i,j+1);
              break;
          }
        }
              print(n); 
      }
    }
     static void print(int n){
        for(int j=0;j<n;j++){
            System.out.print((int)a[j]+" ");
        }
        System.out.println();
    }
    
}
