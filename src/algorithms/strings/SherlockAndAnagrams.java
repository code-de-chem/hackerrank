package algorithms.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class SherlockAndAnagrams {
    private static Map<String,Integer> map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i < t; i++){
            String s = in.next();
            map = new HashMap<>();
            for(int j=1;j<=s.length();j++){
                for(int k =0; k+j<=s.length();k++){
                    addToMap(sortString(s.substring(k, k+j)));
                }
            }
            int res = 0;
            for(Entry key:map.entrySet()){
                if((int)key.getValue()>1)
                    res+=chooseTwo((int)key.getValue());
            }
            System.out.println(res);
        }
    }
    private static void addToMap(String s){
        if(map.containsKey(s)){
            map.put(s, map.get(s)+1);
        }
        else{
            map.put(s, 1);
        }
    }
    private static String sortString(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
    private static int chooseTwo(int n){
        return (n*(n-1))/2;
    }
}
