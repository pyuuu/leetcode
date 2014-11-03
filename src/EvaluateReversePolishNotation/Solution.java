package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created by xijueyp on 14-11-1.
 */
public class Solution {
    // 就是后缀表达式转化
    Stack<Integer> stack = new Stack<Integer>();
    int result = 0;

    public int evalRPN(String[] tokens) {
        for(String s : tokens){
            if (isSign(s)){
                // 计算数字
                stack.add(calculate(s));
            }
            else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public boolean isSign(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int calculate(String sign){
        int a = stack.pop();
        int b;
        if (stack.empty())
            b=0;
        else
            b = stack.pop();
        switch (sign.charAt(0)){
            case '+':
                return b+a;
            case '-':
                return b-a;
            case '*':
                return b*a;
            case '/':
                return b/a;
            default:
                return 0;
        }
    }

    public static void main(String ap[]){
        System.out.println(new Solution().evalRPN(new String[]{"2"}) );
    }
}