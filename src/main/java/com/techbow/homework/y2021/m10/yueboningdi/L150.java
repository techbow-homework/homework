import java.util.Stack;

/*
L150. Evaluate Reverse Polish Notation
 */
public class L150 {
    public static int evalRPN(String[] tokens){
        //corner case
        if (tokens == null || tokens.length == 0){
            throw new IllegalArgumentException("Empty input RPN expression string array!");
        }

        Stack<Integer> stackNum = new Stack<>();
        int i = 0;
        while (i < tokens.length){
            String token = tokens[i];
            if (isNumber(token)){
                stackNum.push(Integer.parseInt(token));
            }else{  //tokens[i] is an operator
                int num1 = stackNum.pop();
                int num2 = stackNum.pop();
                int ansTmp = 0;
                switch (token){
                    case "+":
                        stackNum.push(num2 + num1);
                        break;
                    case "-":
                        stackNum.push(num2 - num1);
                        break;
                    case "*":
                        stackNum.push(num2 * num1);
                        break;
                    case "/":
                        stackNum.push(num2 / num1);
                        break;
                }
            }
            i++;
        }
        return stackNum.pop();
    }

    public static boolean isNumber(String token){
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

    public static void main(String[] args){
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
