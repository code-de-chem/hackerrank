package temp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class HLinkingGraph {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n];
        for(int i =0; i<n; i++){
            nodes[i] = new Node(i+1);
        }
        for(int i = 0; 2*i+2 < n; i++){
            nodes[i].left = nodes[2*i+1];
            nodes[i].right = nodes[2*i+2];
        }
        for(int i = 0; 2*i+2 < n; i++){
            //System.out.println(nodes[i].val +":"+nodes[2*i+1].val+":"+nodes[2*i+2].val);
        }
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        list1.add(nodes[0]);
        System.out.println(nodes[0] +" "+ nodes[0].next);
        int i = 0,j=1;
        while(j<n-1){
            if(i%2==0){
                for(Node temp : list1){
                    list2.add(temp.left);
                    list2.add(temp.right);
                    j+=2;
                }
                list1 = new ArrayList<>();
                for(int k = 0; k < list2.size()-1;k++){
                    list2.get(k).next = list2.get(k+1);
                }
                //System.out.println(list2);
                Node node = list2.get(0);
                while(node != null){
                    System.out.print(node+" ");
                    node = node.next;
                }
                System.out.println(node);
            }
            else{
                for(Node temp : list2){
                    list1.add(temp.left);
                    list1.add(temp.right);
                    j+=2;
                }
                list2 = new ArrayList<>();
                for(int k = 0; k < list1.size()-1;k++){
                    list1.get(k).next = list1.get(k+1);
                }
                //System.out.println(list1);
                Node node = list1.get(0);
                while(node != null){
                    System.out.print(node+" ");
                    node = node.next;
                }
                System.out.println(node);//System.out.println(list1);
            }
            i++;
        }
        
    }
    
    static class Node{
        Node left, right, next;
        int val;
        Node(int val){
            this.val = val;
        }
        
        @Override
        public String toString(){
            return ""+val;
        }
        
    }
}
