package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class TheGridSearch {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t= in.nextInt();
        while(t-->0){
            int gR = in.nextInt();
            int gC = in.nextInt();
            String[] grid = new String[gR];
            for(int i = 0; i < gR; i++){
                grid[i]=in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] pat = new String[r];
            for(int i = 0; i < r; i++){
                pat[i]=in.next();
            }
            boolean flag = false;
            for(int i = 0; i+r <= gR; i++){
                //System.out.println(i);
                int temp=-1;
                while(grid[i].indexOf(pat[0], temp+1)!=-1){
                    temp = grid[i].indexOf(pat[0], temp+1);
                    //System.out.println("temp: "+temp+" "+grid[i].indexOf(pat[0], temp+1));
                    flag = true;
                    for(int j = 1; j < r; j++){
                        //System.out.println("j= "+j+" "+temp+" "+grid[i+j].indexOf(pat[j]));
                        if(!pat[j].equals(grid[i+j].substring(temp, temp+pat[0].length()))){
                            flag = false;
                            break;
                        }
                    }
                
                if(flag){
                    System.out.println("YES");
                    break;
                }
                }
                if(flag){
                    break;
                }
            }
            if(!flag){
                System.out.println("NO");
            }
        }
    }
}
