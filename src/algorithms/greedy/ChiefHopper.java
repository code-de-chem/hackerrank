package algorithms.greedy;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class ChiefHopper {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int n = in.nextInt();
            int[] array = new int[n];
            for(int i = 0; i < n; i++){
                array[i] = in.nextInt();
            }
            int e = 0;
            for(int i = n-1; i >=0 ; i--){
                e = (int)((int)(e+array[i]+1)/2);
            }
            System.out.println(e);
        }
    }
}
