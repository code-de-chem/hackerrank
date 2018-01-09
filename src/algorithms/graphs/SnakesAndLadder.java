package algorithms.graphs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kewl
 */
public class SnakesAndLadder {

    static InputStream ins = null;
    static final String BASE_PATH = System.getProperty("user.dir");
    static final File file = new File(BASE_PATH + "\\src\\io\\input.txt");

    static {
        try {
            ins = new FileInputStream(file);
        } catch (Exception ex) {
            Logger.getLogger(SnakesAndLadder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(ins);
        int t = in.nextInt();
        Node[] nodes;
        while(t-->0){
            nodes = new Node[101];
            for(int i = 1; i < 101; i++){
                nodes[i] = new Node(i);
            }
            for(int i = 1; i < 101; i++){
                for(int j =1; j < 7; j++){
                    if(i+j<101){
                        nodes[i].next.add(new Edge(i+j,1));
                    }
                }
            }
            int l = in.nextInt();
            for(int i =0; i < l; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                nodes[a].reset();
                nodes[a].next.add(new Edge(b, 0));
            }
            int s = in.nextInt();
            for(int i =0; i < s; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                nodes[a].reset();
                nodes[a].next.add(new Edge(b, 0));
            }
            List<Integer> list = new ArrayList<>();
            nodes[1].dist = 0;
            list.add(1);
            boolean[] v = new boolean[101];
            v[1] = true;
            while(!list.isEmpty()){
                int curr = list.remove(0);
                for(Edge temp: nodes[curr].next){
                    if(!v[temp.to]){
                        list.add(temp.to);
                        v[temp.to] = true;
                    }
                    nodes[temp.to].dist = Math.min(nodes[temp.to].dist, nodes[curr].dist+temp.weight);
                }
            }
            System.out.println(nodes[100].dist==Integer.MAX_VALUE?-1:nodes[100].dist);
        }
    }
    static class Node{
        int n,dist;
        List<Edge> next = new ArrayList<>();
        Node(int n){this.n = n;dist = Integer.MAX_VALUE;}
        void reset(){next = new ArrayList<>();}
    }
    static class Edge{
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            ins.close();
        } catch (IOException ex) {
            Logger.getLogger(SnakesAndLadder.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
