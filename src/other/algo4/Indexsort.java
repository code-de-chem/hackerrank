package other.algo4;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class Indexsort {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = 5;
        Alpha[] alpha = new Alpha[n];
        for(int i=0;i<n;i++){
            String temp = in.next();
            int tk = in.nextInt();
            alpha[i] = new Alpha(temp, tk);
        }
        int[] count = new int[r+1];
        Alpha[] aux = new Alpha[n];
        for(int i = 0; i < n; i++)
            count[alpha[i].key+1]++;
        for(int i=0; i < r;i++)
            count[i+1] += count[i];
        for(int i = 0; i < n; i++)
            aux[count[alpha[i].key]++] = alpha[i];
        for(Alpha temp : aux)
            System.out.println(temp);
    }
    
    static class Alpha{
        String val;
        int key;
        Alpha(String val, int key){
            this.val = val;
            this.key = key;
        }
        @Override
        public String toString(){
            return val;
        }
    }
    
}
