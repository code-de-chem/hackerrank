package lab.practical.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class DiceRoll {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        List<Integer> list = new ArrayList<>();
        diceRollSum(n, sum, 0, list);
    }
    
    static void diceRoll(int dice, List<Integer> list){
        if(dice == 0)
            System.out.println(list);
        else{
            for(int i = 1; i <= 6 ; i++){
                list.add(i);
                diceRoll(dice-1, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    static void diceRollSum(int dice, int sum, int currSum, List<Integer> list){
        if(currSum == sum && dice == 0)
            System.out.println(list);
        else if(currSum < sum && currSum + 6*dice >= sum){
            for(int i = 1; i <= 6 ; i++){
                list.add(i);
                diceRollSum(dice-1,sum, currSum+i, list);
                list.remove(list.size()-1);
            }
        }
    }
}
