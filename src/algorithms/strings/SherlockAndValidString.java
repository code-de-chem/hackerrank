/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class SherlockAndValidString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        int[] bucket = new int[26];
        Arrays.fill(bucket,0);
        for(int i = 0; i<s.length();i++)
            bucket[s.charAt(i)-97]++;
        int max = 0,min = 1;
        for(int temp:bucket){
            max = Math.max(max, temp);
            if(temp!=0)
                min = Math.min(max, temp);
        }
        int maxC=0,minC=0,otherC=0;
        for(int temp:bucket){
           if (temp!=0){
               if(temp==max)maxC++;
               else if(temp==min)minC++;
               else otherC++;
           }
        }
        if(min==1 && minC ==1 && otherC == 0)
            System.out.println("YES");
        else if(Math.abs(maxC-minC)>1)
            System.out.println("NO");
        
    }
}
