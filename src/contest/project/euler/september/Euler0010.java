package contest.project.euler.september;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Saurabh Singh
 */
public class Euler0010 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Vector<BigInteger> vec = new Vector<>();
        Vector<BigInteger> sum = new Vector<>();
        int[] index = new int[1000001];
        vec.add(BigInteger.valueOf(2L));
        sum.add(BigInteger.valueOf(2L));
        int k = 1;
        index[2] = 0;
        for(int i = 0; i < t; i++){
            BigInteger n = in.nextBigInteger();
            if(vec.get(k-1).compareTo(n) >= 0){
                BigInteger temp = n.nextProbablePrime();
                /**if(n.compareTo(vec.get(index[temp.intValue()]-1))<0){
                    System.out.println(sum.get(k-1));
                }*/
                
                    System.out.println(sum.get(index[temp.intValue()]-1));
                
            }
            else{
                BigInteger temp = vec.get(k-1).nextProbablePrime();
                do{
                    vec.add(temp);
                    index[temp.intValue()] = k-1;
                    temp = temp.add(sum.get(k-1));
                    sum.add(temp);
                    k++;
                    temp = vec.get(k-1).nextProbablePrime();
                }while(temp.compareTo(n) <= 0);
                System.out.println(sum.get(index[vec.get(k-1).intValue()]+1));
            }
        }
    }
}
