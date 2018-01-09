package lab.practical;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 * 
 * input format
 * first line contains n no of char in alphabets
 * next n line is value of char and its frequency
 * last line is the string need to be compressed
 * 
 * output format
 * first line compressed value
 * second line uncompressed value
 */
public class Huffman {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String val = in.next();
            int freq = in.nextInt();
            Node temp = new Node(val, freq, true, null, null);
            pq.add(temp);
        }
        while(pq.size() > 1){
            Node tempLeft = pq.poll();
            Node tempRight = pq.poll();
            tempLeft.child = 0;
            tempRight.child = 1;
            Node temp = new Node(null,tempLeft.freq+tempRight.freq, false, tempLeft, tempRight);
            temp.left.parent = temp;
            temp.right.parent = temp;
            pq.add(temp);
        }
        String input = in.next();
        print(pq.peek().left);
        pq.peek().visited = true;
        Deque<Node> t = new LinkedList<>();
        t.add(pq.peek());
        while(!t.isEmpty()){
            Node temp = t.poll();
            temp.visited = true;
            if(temp.left != null && !temp.left.visited)
                t.add(temp.left);
            if(temp.right != null && !temp.right.visited)
                t.add(temp.right);
            if(temp.leaf){
                map.put(temp.value, print(temp));
            }
        }
        StringBuilder comp = new StringBuilder("");
        for(int i =0; i < input.length(); i++){
            String temp = String.valueOf(input.charAt(i));
            comp.append(map.get(temp));
            System.out.print(map.get(temp));
        }
        System.out.println();
        for(int i = 0; i < comp.length(); ){
            Node curr = pq.peek();
            while(!curr.leaf){
                if(comp.charAt(i) == '0'){
                    curr = curr.left;
                }
                else if(comp.charAt(i) == '1'){
                    curr = curr.right;
                }
                i++;
            }
            System.out.print(curr.value);
        }
        System.out.println();
    }
    
    static String print(Node curr){
        if(!curr.leaf)
            return null;
        StringBuilder temp = new StringBuilder("");
        while(curr.parent != null){
            temp.append(curr.child);
            curr = curr.parent;
        }
        return temp.reverse().toString();
    }
    
    static class Node implements Comparable<Node>{
        Node left, right, parent;
        int child, freq;
        String value;
        boolean leaf, visited = false;
        
        Node(String value, int freq, boolean leaf, Node left, Node right){
            this.value= value;
            this.freq = freq;
            this.leaf = leaf;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public int compareTo(Node that){
            if(this.freq > that.freq)
                return 1;
            else if(this.freq < that.freq)
                return -1;
            else
                return 0;
        }
    }
}
