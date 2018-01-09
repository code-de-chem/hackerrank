package contest.project.euler.september;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class Euler0008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            String noString = in.next();
            char[] nos = noString.toCharArray();
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < nos.length-k; j++){
                int prod = 1;
                for(int l = 0;l < k; l++){
                    prod *= (nos[j+l]-48);
                }
                if(prod > max)
                    max = prod;
            }
            System.out.println(max);
        }
    }
}
