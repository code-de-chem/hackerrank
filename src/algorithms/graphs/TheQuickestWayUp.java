package algorithms.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hp1
 */
public class TheQuickestWayUp {
    static Scanner in = new Scanner(System.in);
    static List<Edge>[] list;
    static int n, m, start = 0, end = 99;
    static Deque<Integer> queue = new ArrayDeque<>();
    static Node[] nodes;
    
    public static void main(String[] args) {
        int t = in.nextInt();
        for (int i = 0; i < t; i++){
            init();
            find(0);
            System.out.println(nodes[99].distance);
        }
    }
    
    static void init(){
        n = in.nextInt();
        list = new List[100];
        for (int j = 0; j < 100; j++) {
            list[j] = new ArrayList<>();
        }
        for (int j = 0; j < n; j++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            list[x].add(new Edge(y, 0));
        }
        m = in.nextInt();
        for (int j = 0; j < n; j++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            list[x].add(new Edge(y, 0));
        }
        for (int j = 0; j < 99; j++) {
            if(list[j].isEmpty()){
                list[j].add(new Edge(j+1, 1));
            }
            else{
                if(j != 98)
                    list[j].add(new Edge(j+2, 2));
            }
        }
    }
    
    static void find(int start){
        
        nodes = new Node[100];
        for (int j = 0; j < 100; j++) {
            nodes[j] = new Node(j, Integer.MAX_VALUE);
        }
        nodes[start].visited = true;
        for (Edge temp : list[nodes[start].vertex]) {
            if(nodes[temp.to].distance > nodes[start].distance + temp.weight){
                nodes[temp.to].distance = nodes[start].distance + temp.weight;
            }
            if(nodes[temp.to].visited == false){
                queue.add(temp.to);
            }
        }
        if(queue.isEmpty() == false){
            start = queue.removeFirst();
            find(start);
        }
    }
    
    static class Node implements Comparable<Node>{
        int vertex, distance;
        boolean visited;
        Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
            this.visited = false;
        }
        @Override
        public int compareTo(Node that) {
            int dist = Integer.compare(this.distance, that.distance);
            if (dist == 0) {
                return Integer.compare(this.vertex, that.vertex);
            } else {
                return dist;
            }
        
        }
    
    }
    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
