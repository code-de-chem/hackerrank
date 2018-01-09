package infinitum16.firsttimer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class LeoNardoPrimeNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        List<Element> elems = new ArrayList<>();
        BigInteger prime = BigInteger.valueOf(1);
        BigInteger prod = BigInteger.valueOf(1);
        int count = 0;
        for(int i = 0; i < 17; i++){
            Element elem = new Element(count, prod);
            elems.add(elem);
            prime = prime.nextProbablePrime();
            prod = prod.multiply(prime);
            count++;
            if(prod.compareTo(new BigInteger("1000000000000000000")) > 0){
                //break;
            }
        }
        
        for (int i = 0; i < q; i++) {
            String tempS = in.next();
            BigInteger curr = new BigInteger(tempS);
            int prevCount = 0;
            for(Element temp : elems){
                int comp = curr.compareTo(temp.value);
                if(comp==0){
                    System.out.println(temp.count);
                    break;
                }else if(comp < 0){
                    System.out.println(prevCount);
                    break;
                }
                prevCount = temp.count;
            }
        }
    }
    static class Element{
        int count;
        BigInteger value;

        public Element(int count, BigInteger value) {
            this.count = count;
            this.value = new BigInteger(value.toString());
        }
    }
}
