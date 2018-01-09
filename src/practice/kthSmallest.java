package practice;

import java.util.PriorityQueue;

/**
 *
 * @author Kewl
 */
public class kthSmallest {
    static int[][] array = {{ 10, 20, 30, 40},{15, 25, 35, 45},{24, 29, 37, 48},{32, 33, 39, 50}};
    
    
    public static void main(String[] args) {
        int n = 0;
        System.out.println("my Method "+" book method");
        for(n=1; n <= array[0].length*array[0].length;n++){
            int a = myMethod(n);
            int b = realMethod(n);
            System.out.print(a+"\t"+b+"\t");
            System.out.println(a==b?"paas":"fail");
        }
    }
    
    static int myMethod(int n){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int j = 0;
        for(int k=0;k<array[0].length; k++){
            queue.add(array[k][k]);
            j++;
            for(int i = 0; i < k; i++){
                queue.add(array[i][k]);
                queue.add(array[k][i]);
                j+=2;
            }
            if(j>n)break;
        }
        while(--n>0){
            queue.poll();
        }
        return queue.peek();
    }
    
    static int realMethod(int n){
        PriorityQueue<Element> queue = new PriorityQueue<>();
        int i = 0;
        for(int j = 0; j <array[0].length; j++)
            queue.add(new Element(array[i][j], i,j));
        
        while(--n>0){
            Element temp = queue.poll();
            if(temp.i+1 < array[0].length){
                queue.add(new Element(array[temp.i+1][temp.j], temp.i+1,temp.j));
            }
        }
        return queue.peek().value;
        
    }
    static class Element implements Comparable<Element>{
        int value,i,j;

        public Element(int value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.value, o.value);
        }
        
    }
}
