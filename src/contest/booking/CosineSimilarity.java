package contest.booking;

/**
 *
 * @author Kewl
 */
public class CosineSimilarity {

    public static double cosineVectorSimilarity(long[] array1, long[] array2) {
        double sum1 = 0, sum2 = 0, sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i];
            sum1 += array1[i] * array1[i];
            sum2 += array2[i] * array2[i];
        }
        return sum / Math.sqrt(sum1 * sum2);
    }

    public static double cosineVectorSimilarity(int[] array1, int[] array2) {
        double sum1 = 0, sum2 = 0, sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i];
            sum1 += array1[i] * array1[i];
            sum2 += array2[i] * array2[i];
        }
        return sum / Math.sqrt(sum1 * sum2);
    }

    public static double cosineVectorSimilarity(double[] array1, double[] array2) {
        double sum1 = 0, sum2 = 0, sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i];
            sum1 += array1[i] * array1[i];
            sum2 += array2[i] * array2[i];
        }
        return sum / Math.sqrt(sum1 * sum2);
    }

    public static double[][] cosineMatrixSimilarity(long[][] mat, boolean transpose) {
        double[][] ans;
        if (transpose) {
            ans = new double[mat[0].length][mat.length];
            for (int i = 0; i < mat.length; i++) {
                long temp1[] = new long[mat[0].length];
                for (int j = 0; j < mat[0].length; j++) {
                    temp1[j] = mat[j][i];
                }
                for (int k = 0; k < mat.length; k++) {
                    long temp2[] = new long[mat[0].length];
                    for (int j = 0; j < mat[0].length; j++) {
                        temp2[j] = mat[j][k];
                    }
                    ans[i][k] = cosineVectorSimilarity(temp1, temp2);
                }
            }
        } else {
            ans = new double[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[0].length; j++){
                    ans[i][j] = cosineVectorSimilarity(mat[i], mat[j]);
                }
            }
        }
        return ans;
    }

}
