package algorithms.graphs;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Deque;

/**
 *
 * @author Saurabh Singh
 */
public class Bfsshortreach {
    
    static int[][] graph;
    static boolean[] visited;
    static int[] distance;
    static int n, start;
    static Scanner scanner;
    static Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args){
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){ 
            init();
        distance[start-1] = 0;
        find(start-1);
        for(int o = 0; o < n; o++){
            if(distance[o] == 10000){
                System.out.print("-1 ");
            }
            else if(distance[o] == 0){
            }
            else{
                System.out.print(distance[o]+" ");
            }
        }
        System.out.println();
        }
    }
    
    static void init(){
        int a, b;
        n = scanner.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];
        distance = new int[n];
        initValues();
        int m = scanner.nextInt();
        for(int j = 0; j < m; j++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            graph[a-1][b-1] = 1;
            graph[b-1][a-1] = 1;
        }
        start = scanner.nextInt();
    }//end init()
    
    static void initValues(){
        for(int k = 0; k < n; k++){
            visited[k] = false;
            distance[k] = 10000;
            for(int l = 0; l < n; l++){
                graph[k][l] = -1;
            } 
        }
    }
    
    static void find(int start){
        
        visited[start] = true;
        for(int j = 0; j < n; j++){
            if(graph[start][j] != -1){
                if(distance[j] > (distance[start] + 6)){
                    distance[j] = distance[start] + 6;
                }
                if(visited[j] == false){
                    queue.add(j);
                }
            }
        }
        if(queue.isEmpty() == false){
            start = queue.removeFirst();
            find(start);
        }
    }
}
