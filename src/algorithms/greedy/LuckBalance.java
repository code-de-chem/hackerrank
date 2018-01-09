package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class LuckBalance {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int n = in.nextInt();
            int k = in.nextInt();
            long sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int a = in.nextInt();
                int b = in.nextByte();
                if(b==0){
                    sum += a;
                }
                else{
                    list.add(a);
                }
            }
            //prettyPrint(list);
            Collections.sort(list);
            //prettyPrint(list);
            for(int i = 0; i< list.size(); i++){
                if(i < list.size()-k){
                    sum -= list.get(i);
                }
                else{
                    sum += list.get(i);
                }
            }
            System.out.println(sum);
        }
    }
    private static void prettyPrint(List<?> list){
        for(Object obj : list)
            System.out.print(obj+" ");
        System.out.println("");
    }
}
