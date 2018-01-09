package algorithms.graphs;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Saurabh Singh
 */
public class EvenTree {
    
    static Scanner scanner = new Scanner(System.in);
    static Vector<Node> vector = new Vector<Node>(4500);
    
    public static void main(String[] args){
        int a,b;
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        
        for(int i=0; i<n ; i++){
            vector.add(new Node(i));
        }
        for(double i=0; i<m ; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            vector.elementAt(a-1).add(b);
            vector.elementAt(b-1).add(a);
            
        }
        
        int start = scanner.nextInt();
        int end   = scanner.nextInt();
        
        vector.elementAt(start-1).setDistance(0);
        
        search(start,0,end);
        
        if(vector.elementAt(end-1).getDistance() != 5000){                   
                    System.out.print(vector.elementAt(end-1).getDistance());
                }
        else
            System.out.print(0);
        
    }
    
    static void search(int start,int dist, int end){
        //System.out.println("called for:"+start+":"+dist+":"+end+":"+vector.elementAt(start-1).getDistance());
        
        Iterator iter = vector.elementAt(start-1).getIter();       
        while(iter.hasNext()){            
                Node temp = (Node)iter.next();               
                if(vector.elementAt(start-1).getDistance() > dist){
                    vector.elementAt(start-1).setDistance(dist + 1);
                }                
                if(temp.isVisited()==false){
                    temp.setVisited(true);
                    search(temp.getInt(),vector.elementAt(start-1).getDistance(),end);
                }                 
            }     
    }
    
    
    
    
    static class Node{
        Node(int p){
            this.p = p;
            this.vector1 = new Vector<Node>(4500);
        }
        void add(int n){
            vector1.add(new Node(n));
        }
        
        boolean isVisited(){
            return visited;
        }
        void setVisited(boolean value){
            visited = value;
        }
        int getDistance(){
            return distance;
        }
        void setDistance(int dist){
            distance = dist;
        }
        Iterator getIter(){
            return vector1.listIterator();
        }
        int getInt(){
            return p;
        }
        
        int p;
        boolean visited = false;
        int distance = 5000;
        private Vector<Node> vector1;
        // end of class node
    }
    
    // end of class Eventree
}
