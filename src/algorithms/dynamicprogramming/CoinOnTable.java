package algorithms.dynamicprogramming;

import java.text.DecimalFormat;

/**
 *
 * @author Saurabh Singh
 */
public class CoinOnTable {
    public static void main(String[] args) {
        double i = 1 << 2;
        DecimalFormat df = new DecimalFormat("#");
        System.out.println(df.format(i));
    }
}
