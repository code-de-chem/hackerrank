package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class EqualChallenge {

    static int[] stepsArray, temp;
    static int steps;

    public static void main(String[] args) {
        init();
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int[] array = new int[n];
                //temp = new int[n];
                for (int j = 0; j < array.length; j++) {
                    array[j] = in.nextInt();
                    //temp[j] = in.nextInt();
                }
                Arrays.sort(array);
                //Arrays.sort(temp);
                subtractMin(array, array[0]);
                int nonzeroIndex = indexOfFirstNonZero(array);
                while (nonzeroIndex != array.length) {
                    int minIndex = indexOfFirstNonZero(array);
                    int minValue = array[minIndex];
                    incrementAll(array, minValue, minIndex);
                    subtractMin(array, minValue);
                    //Arrays.sort(array);
                    nonzeroIndex = indexOfFirstNonZero(array);
                    //prettyPrint(array);
                }
                //prettyPrint(temp);
                System.out.println(steps);
            }
        }
    }

    private static void prettyPrint(int[] array) {
        for (int temp : array) {
            System.out.print(temp + " ");
        }
        System.out.println("");
    }

    private static void init() {
        steps = 0;
        stepsArray = new int[2001];
        stepsArray[0] = 0;
        stepsArray[1] = stepsArray[2] = stepsArray[5] = 1;
        stepsArray[3] = stepsArray[4] = 2;
        for (int i = 6; i < stepsArray.length; i++) {
            stepsArray[i] = Math.min(stepsArray[i - 1], Math.min(stepsArray[i - 2], stepsArray[i - 5])) + 1;
        }
    }

    private static void incrementAll(int[] array, int by, int except) {
        //System.out.println("going to increment all by "+by+" but element at "+(except+1)+" with stepsArray value of "+stepsArray[by]);
        array[except] -= by;
        //temp[except] -= by;
        for (int i = 0; i < array.length; i++) {
            array[i] += by;
            //temp[i] += by;
        }
        steps += stepsArray[by];
        //prettyPrint(temp);
    }

    private static void subtractMin(int[] array, int val) {
        //System.out.println("going to subtract "+val+" from all");
        for (int i = 0; i < array.length; i++) {
            array[i] -= val;
        }
    }

    private static int indexOfMin(int[] array) {
        int min = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int indexOfFirstNonZero(int[] array) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                return i;
            }
        }
        return array.length;
    }
}
