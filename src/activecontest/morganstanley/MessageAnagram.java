package activecontest.morganstanley;

import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class MessageAnagram {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String wrong = in.next();
            String original = in.next();
            int del = in.nextInt();
            int ins = in.nextInt();
            int upd = in.nextInt();
            int[] w = new int[26];
            int[] o = new int[26];
            for(int j = 0; j < 26; j++){
                w[j]=0;o[j]= 0;
            }
            for(char c : wrong.toCharArray()){
                w[c-97]++;
            }
            for(char c : original.toCharArray()){
                o[c-97]++;
            }
            int sumNeg = 0, sumPosi = 0;
            for(int j = 0; j < 26; j++){
                int temp = o[j] - w[j];
                if(temp > 0)
                    sumPosi += temp;
                else if (temp < 0)
                    sumNeg += temp;
            }
            int cost = 0;
            if(mod(sumPosi) == mod(sumNeg)){
                if((mod(sumPosi) * upd) > (mod(sumPosi) *(ins + del)))
                    cost += sumPosi *(ins + del);
                else
                    cost += sumPosi * upd;
            }
            else if(sumPosi < mod(sumNeg)){
                cost += del * mod((sumPosi - mod(sumNeg)));
                if((mod(sumPosi) * upd) > (mod(sumPosi) *(ins + del)))
                    cost += sumPosi *(ins + del);
                else
                    cost += sumPosi * upd;
            }
            else if(sumPosi > mod(sumNeg)){
                cost += ins * mod((mod(sumNeg) - sumPosi));
                if((mod(sumNeg) * upd) > (mod(sumNeg) *(ins + del)))
                    cost += mod(sumNeg) *(ins + del);
                else
                    cost += mod(sumNeg) * upd;
            }
            System.out.println(cost);
        }
    }
    static int mod(int a){
        if(a >= 0)
            return a;
        else 
            return -a;
    }
}
