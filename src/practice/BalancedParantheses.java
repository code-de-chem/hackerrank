package practice;

import java.util.Stack;

/**
 *
 * @author Kewl
 * 
 * Given an expression string exp, 
 * write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. 
 * For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 */
public class BalancedParantheses {
    public static void main(String[] args) {
        String curr = "[()]{}{[()()]()}";
        System.out.println(value(curr));
    }
    static boolean value(String exp){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(c=='{'||c=='['||c=='('){
                stack.push(""+c);
            }else if(c=='}'||c==']'||c==')'){
                String temp = stack.pop();
                if(!compare(temp, ""+c))return false;
            }
        }
        if(!stack.empty())return false;
        return true;
    }
    static boolean compare(String a, String b){
        if(a.equalsIgnoreCase("(")&&b.equalsIgnoreCase(")")){
            return true;
        }else if(a.equalsIgnoreCase("[")&&b.equalsIgnoreCase("]")){
            return true;
        }else if(a.equalsIgnoreCase("{")&&b.equalsIgnoreCase("}")){
            return true;
        }
        return false;
    }
}
