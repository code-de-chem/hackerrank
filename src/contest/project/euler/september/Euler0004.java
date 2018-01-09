package contest.project.euler.september;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Saurabh Singh
 * 
 * six digit palindrome by product of two three digit palindromes
 */
public class Euler0004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int prev=0;
            LinkedList<Integer> list = new LinkedList<>();
            for(int j = 100; j <= 999; j++){
                for(int k = 100; k <= 999; k++){
                    int prod = j * k;
                    if(prod > n)
                        break;
                    else if(palindrome(prod))
                        if(!list.contains(prod))
                            list.add(prod);
                }
                Object[] list1 = list.toArray();
                Arrays.sort(list1);
                for( Object temp1 : list1){
                    int temp = (int)temp1;
                    if(temp < n && temp > prev){
                        prev = temp;
                    }
                    
                }
            }
            System.out.println(prev);
        }
    }
    
    static boolean palindrome(int a){
        boolean flag = true;
        String temp = a + "";
        if(temp.length()!= 6)
            return false;
        for(int i = 0; i < (temp.length()+1)/2; i++){
            if(temp.charAt(i) != temp.charAt(temp.length()-i-1))
                flag = false;
        }
        return flag;
        
    }
}
