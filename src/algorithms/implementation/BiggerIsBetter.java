package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class BiggerIsBetter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            StringBuilder curr = new StringBuilder(in.next());
            int i = curr.length() - 1;
            for (; i > 0; i--) {
                if (curr.charAt(i - 1) < curr.charAt(i)) {
                    break;
                }
            }
            if (i <= 0) {
                System.out.println("no answer");
                continue;
            }
            char a = curr.charAt(i - 1);
            int j = curr.length() - 1;
            for (; j > 0; j--) {
                if (curr.charAt(j) > a) {
                    break;
                }
            }
            curr.setCharAt(i-1, curr.charAt(j));
            curr.setCharAt(j, a);
            j = curr.length()-1;
            while(i<j){
                char temp = curr.charAt(i);
                curr.setCharAt(i, curr.charAt(j));
                curr.setCharAt(j, temp);
                i++;j--;
            }
            System.out.println(curr);
        }
    }

}
