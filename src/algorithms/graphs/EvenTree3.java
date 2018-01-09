package algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class EvenTree3 {
    static Map<Integer,Node> map;
    static int n;
    static List<Node> list;
    static boolean[] v;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        map = new HashMap<>();
        v = new boolean[n+1];
        list = new ArrayList<>();
        for(int i = 1; i <=n; i++){
            map.put(i, new Node(i));
        }
        for(int i = 0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            map.get(a).edges.add(b);
            map.get(b).edges.add(a);
        }
        v[1] = true;
        dfs(1);
        int count = 0;
        for(int i = 1; i <=n; i++){
            if(map.get(i).nodes%2==0)count++;
        }
        System.out.println(count-1);
    }
    
    public static void dfs(int x){
        List<Integer> temp = map.get(x).edges;
        //System.out.print(x+" is connected with ");
        //prettyPrint(temp);
        for(int i=0; i < temp.size(); i++){
            int temp1 = temp.get(i);
            //System.out.println("going to test "+temp1);
            if(!v[temp1]){
                v[temp1] = true;
                dfs(temp1);
                map.get(x).nodes += map.get(temp1).nodes;
            }
        }
        //System.out.print(x+" in return is connected with ");
        //prettyPrint(temp);
        
    }
    static void prettyPrint(List<Integer> list){
        for(Object obj : list)System.out.print(obj+" ");
        System.out.println("");
    }
    static class Node{
        int value, nodes;
        List<Integer> edges;
        
       
        Node(int value) {
            this.edges = new ArrayList<>();
            this.value = value;
            this.nodes = 1;
        }
        
    }
}
