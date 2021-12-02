/*
L227. Basic Calculator II
 */


import java.util.Stack;

public class L227 {
    public static int calculate(String s) {
        //corner case
        if (s == null || s.length() == 0){
            throw new IllegalArgumentException("Empty input expression!");
        }
        Stack<Integer> stack = new Stack<Integer>();
        char preOp= '+';   //1 represent positive, -1 represent negative.
        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == ' '){
                i++;
            }else if (s.charAt(i) == '+'){
                preOp = '+';
                i++;
            }else if (s.charAt(i) == '-'){
                preOp = '-';
                i++;
            }else if (s.charAt(i) == '*'){
                preOp = '*';
                i++;
            }else if (s.charAt(i) == '/'){
                preOp = '/';
                i++;
            }else if (Character.isDigit(s.charAt(i))){
                int tmp = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    tmp = tmp * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (preOp == '+'){
                    stack.push(tmp);
                }else if (preOp == '-'){
                    stack.push(-tmp);
                }else if (preOp == '*'){
                    tmp = tmp * stack.pop();
                    stack.push(tmp);
                }else if (preOp == '/'){
                    tmp = stack.pop() / tmp;
                    stack.push(tmp);
                }
            }
        }
        int ans = 0;
        while (!stack.empty()){
            ans += stack.pop();
        }
        return ans;
    }
}
