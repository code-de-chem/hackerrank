package contest.weekOfCode23;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class TreasureHunting {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        double[] array = new double[4];
        for(int i = 0; i < 4; i++){
            array[i] = in.nextDouble();
        }
        double xa = array[0]/array[2];
        double yb = array[1]/array[3];
        double k = xa+yb;
        double n = yb-xa;
        k/=2;
        n/=2;
        Double truncatedDouble = new BigDecimal(k).setScale(12, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(truncatedDouble);
        truncatedDouble = new BigDecimal(n).setScale(12, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(truncatedDouble);
    }
}
