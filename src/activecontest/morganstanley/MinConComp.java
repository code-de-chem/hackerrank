package activecontest.morganstanley;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 * 
 * problem 3 Minimum connected component
 */
public class MinConComp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] weight = new int[n];
        int[] nodes = new int[n];
        int[] nw = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = in.nextInt();
            nodes[i] = i;
            nw[i] = weight[i];
            pq.add(weight[i]);
        }
        int a, b, minA, minB, minW, min;
        for(int i = 0; i < q; i++){
            a = in.nextInt();
            b = in.nextInt();
            int temp;
            if(a > b){
                temp = a;
                a = b; 
                b = temp;
            }
            minA = nodes[a-1];
            minB = nodes[b-1];
            if(minA != minB){
                min = Integer.MAX_VALUE;
                pq.remove((Integer)nw[minA]);
                pq.remove((Integer)nw[minB]);
                minW = nw[minA] + nw[minB];
                pq.add(minW);
                for(int j = 0; j < n; j++){
                    if(nodes[j] == minB){
                        nodes[j] = minA;
                    }
                    if(nodes[j]==minA || nodes[j] == minB)
                        nw[j] = minW;
                    if(min > nw[j])
                        min = nw[j];
                }
                
            }
            System.out.println(pq.peek());
        }
    }
    
    
    
}
