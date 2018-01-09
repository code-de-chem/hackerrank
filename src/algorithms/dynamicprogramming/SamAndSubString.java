package algorithms.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class SamAndSubString {

    static BigInteger sum, prevSum;
    static StringBuilder builder;

    public static void main(String[] args) {
        init();
        //long start = System.currentTimeMillis();
        try (Scanner in = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 200; i++) {
                sb.append("9");
            }
            String curr = sb.toString();//in.next();
            prevSum = BigInteger.valueOf(new Long("" + curr.charAt(curr.length() - 1)));
            sum = sum.add(prevSum);
            int k = 1;
            //System.out.println(prevSum+" : "+sum);
            //System.out.println("entering in loop after " + (System.currentTimeMillis() - start) + " milliSeconds.");
            //start = System.currentTimeMillis();
            for (int i = curr.length() - 2; i >= 0; i--) {
                String temp = "" + curr.charAt(i);
                builder.append("1");
                BigInteger temp1 = new BigInteger(builder.toString());
                temp1 = temp1.multiply(BigInteger.valueOf(new Long(temp)));
                prevSum = prevSum.add(temp1);
                sum = sum.add(prevSum);
                //System.out.println(prevSum+" : "+sum);
                //if (i % 2000 == 0) {
                    //System.out.println("processing... counter " + (k++) + " in " + (System.currentTimeMillis() - start) + " milliSeconds.");
                    //start = System.currentTimeMillis();
                //}
            }
            long num = 1000000007;
            //System.out.println(sum);
            System.out.println(sum.mod(BigInteger.valueOf(num)));

        } catch (Exception ex) {

        }
    }

    private static void init() {
        sum = BigInteger.ZERO;
        prevSum = BigInteger.ZERO;
        builder = new StringBuilder("1");
    }
}
