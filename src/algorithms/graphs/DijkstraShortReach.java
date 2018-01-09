package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;



/**
 *
 * @author Saurabh Singh
 */
public class DijkstraShortReach {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
        int n, m, t;
        t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            n = scanner.nextInt();
            m = scanner.nextInt();
            List<Edge>[] list = new List[n];
            for (int j = 0; j < n; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < m; j++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                int r = scanner.nextInt();
                list[x].add(new Edge(y, r));
                list[y].add(new Edge(x, r));
            }
            int start = scanner.nextInt()-1;
            int[] dist = dijkstra(list, start);
            for (int o = 0; o < dist.length; o++) {
                if(dist[o] == Integer.MAX_VALUE){
                System.out.print("-1 ");
            }
            else if(dist[o] == 0){
            }
            else{
                System.out.print(dist[o]+" ");
            }
            }
            System.out.println();
        }
        
    }

    private static int[] dijkstra(List<Edge>[] list, int start) {
        int[] dist = new int[list.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        int distance;
        Node[] nodes = new Node[list.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node first = new Node(start, 0);
        nodes[start] = first;
        pq.add(first);
        while(!pq.isEmpty()){
            Node near = pq.poll();
            for(Edge edge : list[near.vertex]){
                distance = dist[near.vertex] + edge.weight;
                if(distance >= dist[edge.to]){
                    continue;
                }
                if(nodes[edge.to] != null){
                    pq.remove(nodes[edge.to]);
                }
                dist[edge.to] = distance;
                Node temp = new Node(edge.to, distance);
                pq.add(temp);
                nodes[edge.to] = temp;
            }
        }
        
        return dist;
    }
    
    
    
    
    
    
    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node>{
        int vertex, distance;
        Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
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
}
