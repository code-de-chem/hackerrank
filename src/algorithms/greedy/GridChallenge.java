package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class GridChallenge {

    private static char[][] grid;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                grid = new char[n][];
                for (int j = 0; j < n; j++) {
                    String temp = in.next();
                    grid[j] = temp.toCharArray();
                }
                sortGrid();
                if (isGridSorted())
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    static void prettyPrint() {
        for (char[] temp : grid) {
            for (char temp1 : temp) {
                System.out.print(temp1 + " ");
            }
            System.out.println("");
        }
    }

    private static void sortGrid() {
        for (char[] temp : grid) {
            Arrays.sort(temp);
        }
    }

    private static boolean isGridSorted() {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (!isColumnSorted(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColumnSorted(int i) {
        int n = grid.length;
        for (int j = 0; j < n - 1; j++) {
            if (grid[j][i] > grid[j+1][i]) {
                return false;
            }
        }
        return true;
    }
}
