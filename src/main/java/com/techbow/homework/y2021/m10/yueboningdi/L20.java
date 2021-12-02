import java.util.Stack;

/*
L20. Valid Parentheses
 */
public class L20 {
    public static boolean isValid(String s) {
        //corner case
        if (s == null || s.length() == 0)   return true;
        //normal case
        Stack<Character> stack = new Stack<Character>();
        for (Character cur : s.toCharArray()){
            if (cur == '(' || cur == '[' || cur == '{'){
                stack.push(cur);
            }else if (cur == ')'){
                //note the case when stack is empty cannot peek
                if (stack.empty()) return false;
                else if (stack.peek() == '('){
                    stack.pop();
                    continue;
                } else return false;
            }else if (cur == ']'){
                if (stack.empty()) return false;
                else if (stack.peek() == '['){
                    stack.pop();
                    continue;
                } else return false;
            }else if (cur == '}'){
                if (stack.empty()) return false;
                else if (stack.peek() == '{'){
                    stack.pop();
                    continue;
                } else return false;
            }
        }
        return stack.empty();
        //if stack is empty,
        //this means all left brackets have been closed by right brackets
        //so string s is valid;
        //if stack is not empty, this means some left brackets have not been closed
        //so string s is not valid.
    }

    public static void main(String[] args){
        String s = "]";
        System.out.println(isValid(s));
    }
}
