package algorithms.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class EvenTree2 {
    Node[] nodes;
    public static void main(String[] args) {
        EvenTree2 et = new EvenTree2();
        et.init();
        et.prettyPrint();
        
    }
    void init(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        nodes = new Node[n+1];
        for(int i = 0; i <= n; i++){
            nodes[i] = new Node(i);
        }
        for(int i = 0;i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            nodes[a].add(nodes[b]);
            nodes[b].add(nodes[a]);
        }
    }
    void prettyPrint(){
        Random random = new Random();
        int temp = random.nextInt(nodes.length-1);
        Deque<Node> queue = new ArrayDeque<>();
        for(int i = 0; i < nodes.length; i++){
            System.out.print(i+"\t");
        }
        System.out.println("");
        boolean[] flags = new boolean[nodes.length];
        Arrays.fill(flags, false);
        queue.add(nodes[1]);
        nodes[0].parent = null;
        nodes[1].parent = nodes[0];
        flags[0] = flags[1] = true;
        while(!queue.isEmpty()){
            Node temp3 = queue.pollFirst();
            //System.out.print("Dealing "+temp3.value+"...");
            flags[temp3.value] = true;
            ArrayList<Node> list1 = temp3.list;
            for(Node temp4:list1){
                //System.out.print(temp4.value+", ");
                if(!flags[temp4.value]){
                    temp4.parent = temp3;
                    queue.add(temp4);
                }
            }
            //System.out.println("");
        }
        queue = new ArrayDeque<>();
        for(int i = 0; i < nodes.length; i++){
            //System.out.print(nodes[i].nodes+"\t");
            if(nodes[i].list.size()==1) {
                queue.add(nodes[i]);
            }
        }
        System.out.println("");
        for(int i = 1; i < nodes.length; i++){
            System.out.print("\t"+nodes[i].parent.value);
        }
        System.out.println("");
        for(Node temp2 : nodes){
            System.out.print(temp2.nodes+"\t");
        }
        System.out.println("");
        Arrays.fill(flags, false);
        while(!queue.isEmpty()){
            prettyPrint(queue);
            for(Node temp2 : nodes){
            System.out.print(temp2.nodes+"\t");
        }
        System.out.println("");
            Node temp1 = queue.pollFirst();
            if(temp1.parent != null){
                temp1.parent.nodes += temp1.nodes;
                queue.add(temp1.parent);
            }
        }
        System.out.println("");
        for(Node temp2 : nodes){
            System.out.print(temp2.nodes+"\t");
        }
        System.out.println("");
    }
    void prettyPrint(Deque<Node> queue){
        for(Node temp : queue)
            System.out.print(temp.value+" ");
        System.out.println("");
    }
    private class Node{
        Node parent;
        int value;
        ArrayList<Node> list;
        int nodes;
        boolean isLeaf;
        Node(int value){
            this.value = value;
            parent = null;
            nodes = 1;
            list = new ArrayList<>();
            isLeaf = false;
        }
        void add(Node node){
            list.add(node);
        }
    }
}
