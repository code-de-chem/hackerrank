package algorithms.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class Prims {
    static Scanner in = new Scanner(System.in);
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static Node[] nodes;
    static boolean[] visited;
    static int weight = 0;
    
    public static void main(String[] args) {
        int n = in.nextInt();
        int e = in.nextInt();
        
        visited = new boolean[n];
        nodes = new Node[n];
        for(int i =0; i < n; i++){
            nodes[i] = new Node(i);
            visited[i] = false;
        }
        int to, from, tempweight;
        Edge tempEdge;
        for(int i = 0; i < e; i++){
            to = in.nextInt() - 1;
            from = in.nextInt() - 1;
            tempweight = in.nextInt();
            tempEdge = new Edge(to, from, tempweight);
            nodes[to].edges.add(tempEdge);
            nodes[from].edges.add(tempEdge);
        }
        int start = in.nextInt() - 1;
        visited[start] = true;
        mstWeight(start);
        System.out.println(weight);
        
    }
    
    static void mstWeight(int start){
        visited[start] = true;
        Iterator iter = nodes[start].getIter();
        while(iter.hasNext()){
            Edge temp = (Edge)iter.next();
            int to = temp.getEither();
            int from = temp.getOther(to);
            
            if(!visited[to] || !visited[from]) 
                pq.add(temp);
            
        }
                
        while(!pq.isEmpty()){
            Edge temp = pq.poll();
            int to = temp.getEither();
            int from = temp.getOther(to);
            if(!visited[to] || !visited[from]){
                weight += temp.weight;
                if(visited[to])
                    mstWeight(from);
                else
                    mstWeight(to);
                
            }
        }
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
        
        Edge(int to, int from , int weight){
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
