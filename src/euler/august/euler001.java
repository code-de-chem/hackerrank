package euler.august;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class euler001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long sum = 0;
        for(int i = 0; i < t; i++){
            int n = scanner.nextInt();
            for(int j = 3; j < n; j++){
                if(j % 3 == 0 || j % 5 == 0){
                    sum += j;
                }
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}
