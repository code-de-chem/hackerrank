package hack101.sep2015;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class XaeroAndBinaryGift {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        if(a.equalsIgnoreCase(b) || a.length() > 1000 || b.length() > 1000)
            System.exit(1);
        
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        if(a.length() != b.length()){
            System.out.println(-1);
        }
        else
            System.out.println(aEqualB(a1, b1));
    }
    static int aEqualB(char[] a1, char[] b1){
        int j =0, k;
        char[] a = Arrays.copyOf(a1, a1.length);
        char[] b = Arrays.copyOf(b1, b1.length);
        Arrays.sort(a1);
        Arrays.sort(b1);
        for(int i = 0; i < a1.length; i++){
            if(a1[i] != b1[i])
                return -1;
            if(a[i] == '0' || a[i] == '1') 
                return -5;
            else if(b[i] == '0' || b[i] == '1')
                return -6;
            if(a[i] != b[i]){
                for(k = i; k < b.length; k++){
                    if(a[i] == b[k])
                        break;
                }
                j++;
                b = swap(b, i , k);
            }
        }
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i])
                return -1;
        }
        
            return j;
        
    }
    static char[] swap(char[] b, int  i , int k){
        char temp = b[i];
        b[i] = b[k];
        b[k] = temp;
        return b;
    }
}
