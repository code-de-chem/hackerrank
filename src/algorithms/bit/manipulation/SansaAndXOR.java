package algorithms.bit.manipulation;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class SansaAndXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            long[] array = new long[n];
            for(int j = 0; j<n; j++){
                array[j] = in.nextLong();
            }
            long res = 0;
            if(n%2==0)
                res = 0;
            else{
                res = array[0];
                for(int j = 2;j<n;j+=2){
                    res = xorValue(res,array[j]);
                }
            }
            System.out.println(res);
        }
    }
    /** @return XOR of two Long*/
    private static long xorValue(long i1, long i2){
        String s1 = Long.toBinaryString(i1), s2 = Long.toBinaryString(i2);
        int s1L =s1.length(), s2L = s2.length();
        if(s1L<s2L){
            for(int i = 0;i<s2L-s1L;i++)
                s1 = "0"+s1;
        }else if(s1L>s2L){
            for(int i = 0;i<s1L-s2L;i++)
                s2 = "0"+s2;
        }
        s1L =s1.length();
        StringBuilder temp = new StringBuilder("");
        for(int i = 0; i <s1L;i++)
            if(s1.charAt(i)!=s2.charAt(i))
                temp.append("1");
            else
                temp.append("0");
        return Long.valueOf(temp.toString(),2);
    }
    
}
