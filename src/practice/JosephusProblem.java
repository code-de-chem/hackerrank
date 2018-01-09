package practice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kewl
 */
public class JosephusProblem {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            list.add(i);
        }
        System.out.println(safePlace(list,0,k-1));
    }
    
    static int safePlace(List<Integer> list, int n, int k){
        if(list.size()==1)return list.get(0);
        int t = (n+k)%list.size();
        list.remove(t);
        return safePlace(list, t, k);
    }
}
