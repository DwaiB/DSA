import java.util.Stack;

public class BasicCalc {
    public static  int calculate(String s) {
        char ch = ' ';
        int result = 0,curr=0,sign=1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i< s.length();i++){
            ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                curr = curr*10+ ch-'0';
            }
            else if(ch == '+'){
                result+= curr*sign;
                curr = 0;
                sign = 1;
            }
            else if( ch == '-'){
                result+= curr*sign;
                curr=0;
                sign = -1;
            }
            else if( ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if( ch == ')'){
                result += curr*sign;
                curr = 0;
                result = result*stack.pop();
                result += stack.pop();
            }
        }
        result+= curr*sign;
        return result;
    }
    public static void main(String[] args) {
        String s = "1+(2-(30+(4-(5+6)-1)+1))+(6+7)";
        int res = calculate(s);
        System.out.println(s+" = "+res);
    }
}
