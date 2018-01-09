package practice;

/**
 *
 * @author Kewl
 */
public class ReverseEachWord {
    public static void main(String[] args) {
        System.out.println("|"+reverse(" i like this program very much")+"|");
    }
    static String reverse(String in){
        StringBuilder build = new StringBuilder("");
        int curr = 0, prev=in.length();
        while(in.lastIndexOf(" ", prev-1)!=-1){
            curr = in.lastIndexOf(" ", prev-1);
            build.append(in.substring(curr+1, prev)).append(" ");
            prev = curr;
        }
        build.append(in.substring(0, curr));
        while(build.charAt(build.length()-1)==' ')build.deleteCharAt(build.length()-1);
        return build.toString();
    }
    
}
