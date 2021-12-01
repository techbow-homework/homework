/*
L224. Basic Calculator
 */

import java.util.Stack;


public class L224 {
    //solution 1
    public static int calculate_1(String s) {
        //corner case
        if (s == null || s.length() == 0){
            throw new IllegalArgumentException("Empty input expression!");
        }
        //sign denote the sign of the current number,
        // 1 represent positive, -1 represent negative
        int sign = 1;
        //parenSignStack stores the sign result
        // integrated by all enclosing parentheses
        // up to the current position
        Stack<Integer> parenSignStack = new Stack<Integer>();
        parenSignStack.push(1);

        int ans = 0;
        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == ' '){
                i++;
            }else if (s.charAt(i) == '+'){
                sign = 1;
                i++;
            }else if (s.charAt(i) == '-'){
                sign = -1;
                i++;
            }else if (s.charAt(i) == '('){
                if (parenSignStack.peek() == sign){ //parenSignStack.peek() and sign are {1,1}, {-1,-1}.
                    parenSignStack.push(1);
                }else{  //parenSignStack.peek() and sign are {1,-1}, {-1,1}.
                    parenSignStack.push(-1);
                }
                sign = 1;   //CAUTION! To avoid "-(3+2)" bug.
                i++;
            }else if (s.charAt(i) == ')'){
                parenSignStack.pop();
                i++;
            }else if (Character.isDigit(s.charAt(i))){
                int tmp = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    //note "i < s.length()" cannot be missing in order to avoid out of bound exception
                    tmp = tmp * 10 + (s.charAt(i) - '0');
                    i++;
                }
                ans += parenSignStack.peek() * sign * tmp;
            }
        }
        return ans;
    }

//    //solution 2
//    public int calculate(String s) {
//
//    }

    public static void main(String[] args){
        String s = "- (3 + (4 + 5))";
        System.out.println(calculate_1(s));
    }
}
