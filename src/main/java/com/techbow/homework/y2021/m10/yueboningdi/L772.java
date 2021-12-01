import java.util.HashMap;
import java.util.Stack;

/*
L772. Basic Calculator III
 */
public class L772 {

    //My solution 1 passed all LC tests for L772, 224, 227
    public static int calculate(String s){
        //corner case
        if (s == null || s.length() == 0){
            throw new IllegalArgumentException("Empty input expression!");
        }

        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('(',0);
        priority.put(')',0);
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);

        Stack<Integer> stackNum = new Stack<>();
        Stack<Character> stackOp = new Stack<>();

        int i = 0;
        //process the expression from left to right
        while (i < s.length()){ //putting i++ in every cases is more safe
            if (s.charAt(i) == ' '){
                i++;
            }else if (s.charAt(i) == '('){
                stackOp.push('(');
                i++;
            }else if (s.charAt(i) == ')'){
                while (stackOp.peek() != '('){
                    basicOperation(stackNum, stackOp);
                }
                stackOp.pop();
                i++;
            }else if (Character.isDigit(s.charAt(i))){
                int tmp = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    tmp = tmp * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stackNum.push(tmp);
            }else{  //s.charAt(i)=='+' or '-' or '*' or '/'
                if (s.charAt(i) == '-') {
                    //'-' represent negative
                    if (i == 0 || s.charAt(i - 1) == '(') {
                        stackNum.push(0);
                    }
                }
                while (!stackOp.empty() && priority.get(stackOp.peek()) >= priority.get(s.charAt(i))){
                    basicOperation(stackNum, stackOp);
                }
                stackOp.push(s.charAt(i));
                i++;
            }
        }
        //evaluate remaining expression
        while (!stackOp.empty()){
            basicOperation(stackNum, stackOp);
        }
        return stackNum.pop();
    }

    public static void basicOperation(Stack<Integer> stackNum, Stack<Character> stackOp){
        int num1 = stackNum.pop();
        int num2 = stackNum.pop();
        int ansTmp = 0;
        char opTmp = stackOp.pop();
        switch (opTmp){
            case '+':
                ansTmp = num2 + num1;
                break;
            case '-':
                ansTmp = num2 - num1;
                break;
            case '*':
                ansTmp = num2 * num1;
                break;
            case '/':
                ansTmp = num2 / num1;
                break;
        }
        stackNum.push(ansTmp);
    }

    public static void main(String[] args){
        //LC 224 failed test case
        String s = "-2+ 1";
        System.out.println(calculate(s));
    }
}