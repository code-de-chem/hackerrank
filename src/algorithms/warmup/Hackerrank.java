package algorithms.warmup;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class Hackerrank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k =0;
        for(int i = 0; i <= t; i++){
            String temp = in.nextLine();
            char[] temp2 = temp.toCharArray();
            boolean flag = true;
            for(int j = 1; j < temp2.length; j++){
                int a = absDiff((int)temp2[j], (int)temp2[j-1]);
                int b = absDiff((int)temp2[temp2.length-j],(int)temp2[temp2.length-j -1]);
                if(a != b)
                    flag = false;
            }
            if(k!=0)
                if(flag)
                    System.out.println("Funny");
                else
                    System.out.println("Not Funny");
            k++;
        }
    }
    static int absDiff(int a, int b){
        return (a>b)? (a-b) : (b-a);
    }

}
