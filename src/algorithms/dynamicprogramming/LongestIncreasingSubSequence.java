package algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Saurabh Singh
 */
public class LongestIncreasingSubSequence {
    
    static int[] lis;
    
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<10;i++)
            list.add(r.nextInt(20));
        prettyPrint(list);
        System.out.println(lisLength(list));
        lisArray(list);
    }
    
    private static void prettyPrint(List<Integer> list){
        for(int temp:list)
            System.out.print(temp+" ");
        System.out.println("");
    }
    
    private static int lisLength(List<Integer> list){
        list.add(0, Integer.MIN_VALUE);
        int n = list.size();
        lis = new int[n];
        for(int i = n-1; i>=0;i--){
            lis[i]=1;
            for(int j = i+1; j <n; j++){
                if(list.get(j)>list.get(i) && lis[i]<lis[j]+1){
                    lis[i] = lis[j]+1;
                }
            }
        }
        list.remove(0);
        return lis[0]-1;
    }
    
    private static void lisArray(List<Integer> list){
        lisLength(list);
        int curr = lis[0];
        for(int i = 1; i <lis.length; i++){
            if(lis[i]==curr-1){
                curr = lis[i];
                System.out.print(list.get(i-1)+" ");
            }
        }
        System.out.println("");
    }
}
