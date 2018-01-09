package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class BeautifulPairs {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int n = in.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i <n; i++){
                int temp = in.nextInt();
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp)+1);
                }
                else{
                    map.put(temp, 1);
                }
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                int temp =in.nextInt();
                if(map.containsKey(temp)){
                    count++;
                    if(map.get(temp)>1){
                        map.put(temp, map.get(temp)-1);
                    }
                    else{
                        map.remove(temp);
                    }
                }
            }
            if(count < n){
                count++;
            }
            else if(count == n){
                count--;
            }
            System.out.println(count);
        }
    }
}
