package LeetCode.stack;

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        if(s.length() == 0 ){
            return s;
        }
        Stack<Integer> stack  = new Stack<Integer>();
        int idx = getString(s),k=0;
        String ip = s, op = "",cur = "";
        if(idx!=0){
            op += ip.substring(0,idx);
            ip = ip.substring(idx);
            idx = 0;
        }
        for(int i = 0; i < ip.length(); i++){
            if(isDigit(ip.charAt(i))){
                k = Integer.parseInt(String.valueOf(ip.charAt(i)));
                ip = ip.substring(i+2);
                stack.push(k);
            }
            if(ip.charAt(i) == ']'){
                k = stack.pop();
                System.out.println("Printing "+op+ " "+k+" times");
                s = "";
                for(int j = 0; j < k;j++){
                    s += op;
                }
                op = s;
                ip = ip.substring(i+1);
            }
            i =  getString(ip);
            if(idx!=0){
                op += ip.substring(0,idx);
                ip = ip.substring(idx);
                idx = 0;
            }
        }
        return op;
    }
    public String decode(String ip,String op, Stack<Integer> stack){
        int 
        System.out.println("Start "+ip+"=> "+op);
        
        System.out.println("Initialize "+ip+"=> "+op);
        if(ip.length() == 0){
            return op;
        }
        int k;
        String s;
        if(isDigit(ip.charAt(idx))){
            k = Integer.parseInt(String.valueOf(ip.charAt(idx)));
            ip = ip.substring(2);
            stack.push(k);
            
            System.out.println("NotDigit Main "+ip+"=> "+op);
        }
        while(!stack.isEmpty()){
            if(ip.length() == 0){
                break;
            }
            idx =  getString(ip);
            if(idx!=0){
                op += ip.substring(0,idx);
                ip = ip.substring(idx);
                idx = 0;
            }
            if(isDigit(ip.charAt(idx))){
                k = Integer.parseInt(String.valueOf(ip.charAt(idx)));
                ip = ip.substring(2);
                System.out.println("Sending "+ip+"=> null");
                op+= decode(ip,"",stack);
                stack.push(k);
            }
            System.out.println(ip+"=> "+op);
            if(ip.charAt(idx) == ']'){
                k = stack.pop();
                System.out.println("Printing "+op+ " "+k+" times");
                s = "";
                for(int i = 0; i < k;i++){
                    s += op;
                }
                op = s;
                ip = ip.substring(idx+1);
            }
        }
        System.out.println("Final "+ip+"=> "+op);
        if(ip.length() !=0 && ip.charAt(0) == ']'){
            return op;
        }
        return op+decode(ip,"",stack);
    }

    public int getString(String s){
        int i = 0;
        while(i < s.length() && (!isDigit(s.charAt(i)) && s.charAt(i) != ']')){
            i++;
        }
        return i;
    }
    public boolean isDigit(char item){
        if(item >=48 && item <=57){
            return true;
        }
        return false;
    }
}