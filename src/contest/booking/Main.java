package contest.booking;

/**
 *
 * @author Kewl
 */
public class Main {
    public static void main(String[] args) {
        int[] array1 = {4,3, 0 ,0,5,0};
        int[] array2 = {5,0,4,0,4,0};
        /**for(int[] temp1: Data.data){
            for(int[] temp2:Data.data)
                System.out.printf("%1.2G \t", CosineSimilarity.cosineVectorSimilarity(temp1,temp2));
            System.out.println("");
        }*/
        /**for(int i =0; i < Data.data.length; i++){
            for(int j=0;j< Data.data[i].length;j++)
                System.out.print(Data.data[j][i]+" ");
            System.out.println("");
        }*/
        System.out.println("without transpose");
        prettyPrint(CosineSimilarity.cosineMatrixSimilarity(Data.data, false));
        //Double ans = CosineSimilarity.cosineVectorSimilarity(array2,array1);
        //System.out.printf("%1.2G", ans);
        System.out.println("with transpose");
        prettyPrint(CosineSimilarity.cosineMatrixSimilarity(Data.data, true));
    }
    static void prettyPrint(double[][] mat){
        for(double[] temp : mat){
            for(double temp1 : temp)
                System.out.printf("%1.2G \t",temp1);
            System.out.println("");
        }
    }
}
