package algorithms.implementation;

import algorithms.graphs.SnakesAndLadder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kewl
 */
public class Bonetrousle {
    static InputStream ins = null;
    static final String BASE_PATH = System.getProperty("user.dir");
    static final String DIR = BASE_PATH + "\\src\\algorithms\\implementation\\";
    static final File file = new File(DIR+"Bonetrousle_input.txt");

    static {
        try {
            ins = new FileInputStream(file);
        } catch (Exception ex) {
            Logger.getLogger(SnakesAndLadder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(ins);
        int t = in.nextInt();
        while(t-->0){
            long n = in.nextLong();
            long k = in.nextLong();
            long b = in.nextLong();
            long s = b*(b-1)/2;
            long a = Math.abs((n-k))/s+1;
            System.out.println(n+" "+k+" "+b+" "+s+" "+a);
            long sum = 0;
            boolean flag  = true;
            ArrayList<Long> list = new ArrayList<>();
            for(int i = 1; i < b; i++){
                long temp = i*a;
                list.add(temp);
                sum += temp;
                System.out.print(temp+" ");
                if(temp>k){
                    flag = false;break;
                }
            }
            System.out.println("");
            if(!flag){
                System.out.println("-1");
            }else{
                for(long temp1:list)
                    System.out.print(temp1+" ");
                System.out.println(n-sum);
            }
        }
        
        
        try {
            expectedOutput();
        } catch (Exception ex) {
            Logger.getLogger(Bonetrousle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void expectedOutput(){
        InputStream outStream = null;
        try {
            File file = new File(DIR+"Bonetrousle_output.txt");
            outStream = new FileInputStream(file);
            Scanner output = new Scanner(outStream);
            System.out.println("Expected Output");
            while(output.hasNextLine()){
                System.out.println(output.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bonetrousle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Bonetrousle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
