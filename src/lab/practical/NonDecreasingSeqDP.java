package lab.practical;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class NonDecreasingSeqDP {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nos = new int[n];
        int[] sol = new int[n];
        for(int i = 0; i < n ; i++){
            nos[i] = in.nextInt();
            sol[i] = -1;
        }
        int max = 1, j = 0;
        
        sol[0] = 1;
        for(int i = 1; i < n; i++){
            if(nos[i] >= nos[i-1]){
                sol[i] = sol[i-1]+1;
                if(sol[i] > max){
                    max = sol[i];
                    j = i;
                }
            }
            else
                sol[i] = 1;
        }
        System.out.println(max);
        while(max > 0){
            System.out.print(nos[j-max+1]+" ");
            max--;
        }
    }
    
}
