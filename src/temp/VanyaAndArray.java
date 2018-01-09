/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class VanyaAndArray {

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            for (int j = i; j >= 0; j--) {
                if (array[j] < array[i]) {
                    f[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (f[i] + f[j] >= k) {
                    count++;
                }
            }
        }
        int a = 10000000;
        System.out.println(a);
    }
}
