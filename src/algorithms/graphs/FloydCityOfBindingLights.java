package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class FloydCityOfBindingLights {
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Node> map = new HashMap<>();
        for(int i = 1; i <= n; i++)
            map.put(i, new Node(i, n));
        for(int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            map.get(a).weights[b] = w;
            map.get(a).edges.put(b, w);
        }
        for(int i = 1; i <= n; i++)
            map.get(i).weights[i]=0;
        for(int j=0;j<5;j++)
            for(int i = 1; i <= n; i++)
                for(int k = 0; k<2; k++)
                    findMinFromSource(map, i);
        int q = in.nextInt();
        for(int i= 0; i < q; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            long dist = map.get(a).weights[b];
            dist = dist==Long.MAX_VALUE?-1:dist;
            System.out.println(dist);
        }
    }
    
    static void findMinFromSource(Map<Integer, Node> map, int source){
        List<Integer> list = new ArrayList<>();
        boolean[] v = new boolean[n+1];
        list.add(source);
        v[source] = true;
        while(!list.isEmpty()){
            int temp = list.remove(0);
            for(int temp2: map.get(temp).edges.keySet()){
                if(!v[temp2]){
                    v[temp2] = true;
                    list.add(temp2);
                }
                map.get(source).weights[temp2] = Math.min(map.get(source).weights[temp2]-map.get(temp).edges.get(temp2), map.get(source).weights[temp])+map.get(temp).edges.get(temp2);
            }
        }
    }
    
    static class Node{
        int value;
        long[] weights;
        Map<Integer, Integer> edges;

        public Node(int value, int n) {
            this.value = value;
            this.weights = new long[n+1];
            Arrays.fill(weights, Long.MAX_VALUE);
            edges = new HashMap<>();
        }
    }
}
