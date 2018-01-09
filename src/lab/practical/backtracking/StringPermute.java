package lab.practical.backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Saurabh Singh
 */
public class StringPermute {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String query, perm = "";
        int n;
        try (Scanner in = new Scanner(System.in)) {
            query = in.next();
            n = in.nextInt();
        }
        //permute(query, perm);
        permute(query, perm, n);
        for(String temp : set)
            System.out.println(temp);
    }
    
    static void permute(String query, String perm){
        if(query.length() == 0)
            set.add(perm);
        else{
            for(int i = 0; i < query.length(); i++){
                char c = query.charAt(i);
                query = query.substring(0, i) + query.substring(i+1);
                perm += c;
                permute(query, perm);
                query = query.substring(0, i) + c + query.substring(i);
                perm = perm.substring(0, perm.length()-1);
            }
        }
    }
    
    static void permute(String query, String perm, int n){
        if(perm.length() == n)
            set.add(perm);
        else{
            for(int i = 0; i < query.length(); i++){
                char c = query.charAt(i);
                query = query.substring(0, i) + query.substring(i+1);
                if(!perm.contains(String.valueOf(c))){
                    perm += c;
                    permute(query, perm,n);
                }
                query = query.substring(0, i) + c + query.substring(i);
                perm = perm.substring(0, perm.length()-1);
            }
        }
    }
}
