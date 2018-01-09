package activecontest.morganstanley;

import java.util.Scanner;

/**
 * @author Saurabh Singh
 */
public class StockValues {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int[] w = new int[n];
            for(int j = 0; j < n; j++){
                w[j] = in.nextInt();
            }
            for(int j = 1; j < n-1; j++){
                if(w[j-1]%2==0 && w[j+1]%2==0){
                    int temp = (w[j-1] + w[j+1])/2;
                    if(mod(w[j] - w[n-j-1]) < mod(temp - w[n-j-1])){
                        w[j] = temp;
                    }
                }
            }
            int sum = 0;
            for(int j = 0; j < n/2; j++){
                sum += mod(w[j] - w[n-j-1]);
            }
            System.out.println(sum);
        }
    }
    static int mod(int a){
        if(a >= 0)
            return  a;
        else
            return -a;
    }
    
}
