package algorithms.graphs;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Saurabh Singh
 */
public class Kruskals {
    static Scanner in = new Scanner(System.in);
    static Node[] nodes;
    static boolean[] visited;
    static int weight = 0;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static Set<Node> setA = new HashSet<>();
    static Set<Node> setB = new HashSet<>();
    static Map<Integer, String> map = new HashMap<>();
    
    static int[] path;
    public static void main(String[] args) {
        int n = in.nextInt();
        int e = in.nextInt();
        
        nodes = new Node[n];
        visited = new boolean[n];
        path = new int[n+1];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i);
            visited[i] = false;
            path[i]=0;
        }
        path[n]=0;
        int tempTo, tempFrom, tempWeight;
        for(int i = 0; i < e; i++){
            tempFrom = in.nextInt() - 1;
            tempTo = in.nextInt() - 1;
            tempWeight = in.nextInt();
            Edge tempEdge = new Edge(tempFrom, tempTo, tempWeight);
            nodes[tempFrom].edges.add(tempEdge);
            nodes[tempTo].edges.add(tempEdge);
            pq.add(tempEdge);
        }
        int start = in.nextInt() - 1;
        visited[start] = true;
        setA.add(nodes[start]);
        int cost = mstKruskal(n, e);
        System.out.println(cost);
    }
    
    static int mstKruskal(int n, int e){
        int x = 0, y = 0, cost = 0;
        while( (x != n - 1) && (y != e)){
            Edge temp = pq.poll();
            if(checkCycle(temp)){
                cost += temp.weight;
                ++x;
            }
            ++y;
        }
        return cost;
    }
    
    static void mstWeight(int start){
        while(!pq.isEmpty()){
            Edge tempEdge = pq.poll();System.out.println(tempEdge);
            int to = tempEdge.getEither();
            int from = tempEdge.getOther(to);
            if( !((setA.contains(nodes[to]) && setA.contains(nodes[from])) || (setB.contains(nodes[to]) && setB.contains(nodes[from])) )){
                visited[to] = visited[from] = true;
                System.out.println("selected "+tempEdge);
                weight += tempEdge.weight;
                setA.add(nodes[to]);
                setB.add(nodes[from]);
            }
        }
    }
    
    static boolean checkCycle(Edge e){
        int  u = e.getEither(), v = e.getOther(u);
        
        while(path[u] > 0)
            u = path[u];
        
        while(path[v] > 0)
            v = path[v];
        
        if(u != v){
            path[u] = v;
            return true;
        }
        return false;
    }
    
    static class Node{
        int node, next, prev, dist;
        LinkedList<Edge> edges = new LinkedList<>();
        
        Node(int node){
            this.node = node;
            this.dist = Integer.MAX_VALUE;
        }
        
        void add(Edge edge){
            edges.add(edge);
        }
        Iterator getIter(){
            return edges.iterator();
        }
    }
    
    static class Edge implements Comparable<Edge>{
        int to, from, weight;
        
        Edge(int from, int to , int weight){
            this.to = to;
            this.from = from;
            this.weight = weight;
        }
        int getEither(){
            return to;
        }
        int getOther(int to){
            if(to == this.to)
                return this.from;
            else
                return this.to;
        }
        
        @Override
        public int compareTo(Edge that){
            if(this.weight > that.weight)
                return 1;
            else if (this.weight < that.weight)
                return -1;
            else
                if(this.to + this.from + this.weight > that.weight + that.from + that.to)
                    return 1;
                else if (this.to + this.from + this.weight < that.weight + that.from + that.to)
                    return -1;
                else
                    return 0;
        }
        
        @Override
        public String toString(){
            return (to+1) +" "+ (from+1) +" " +weight;
        }
    }
}
