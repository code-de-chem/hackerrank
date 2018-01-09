package contest.project.euler.september;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 * 
 * smallest positive number of multiples 1 to N
 */
public class Euler0005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t ; i++){
            int n = in.nextInt();
            long prod = 2;
            for(int  j = 2; j <=n; j++){
                int temp = j;System.out.println("temp1 "+temp);
                for(int k = 2; k < j; k++){
                    if(temp % k == 0)
                        temp = temp / k;System.out.println("temp2 "+temp);
                }
                prod *= temp;System.out.println("temp3 "+temp);
            }
            System.out.println(prod);
        }
    }
}
