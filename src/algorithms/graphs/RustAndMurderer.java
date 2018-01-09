package algorithms.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Kewl
 */
public class RustAndMurderer {
    static List<Integer>[] adj;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
       
        while(t-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            adj = new ArrayList[n+1];
            for(int i = 0; i < n+1; i++)
                adj[i] = new ArrayList<Integer>();
            
            while(m-->0){
                int a = in.nextInt();
                int b = in.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }
            int s = in.nextInt();
            int[] ans = bfs(s, n);
            for(int i =1; i < ans.length; i++){
                if(i!=s)System.out.print(ans[i]+" ");
            }
            System.out.println("");
        }
    }
    
    static int[] bfs(int s, int n){
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(s);
        vis[s] = true;
        Set<Integer> l1 = new TreeSet<Integer>();
        Set<Integer> l2 = new TreeSet<Integer>();
        for(int i = 1; i < n+1; i++)
            if(i!=s)l1.add(i);
        
        while(q.size()>0){
            int u = q.removeFirst();
            for(int temp : adj[u]){
                if(!vis[temp]){
                    l1.remove(temp);
                    l2.add(temp);
                }
            }
            for(int temp : l1){
                vis[temp] = true;
                dis[temp] = dis[u]+1;
                q.addLast(temp);
            }
            l1 = l2;
            l2 = new TreeSet<Integer>();
        }
        return dis;
    }
}
