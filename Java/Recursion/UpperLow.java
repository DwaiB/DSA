package Java.Recursion;

import java.util.ArrayList;
import java.util.List;

public class UpperLow {
    public List<String> upperLower(String s){
        List<String> res = new ArrayList<String>();
        solve(s,"",res);
        return res;
    }
    public void solve(String ip,String op, List<String> res){
        if(ip.length() == 0){
            res.add(op);
            return;
        }
        String op1 = op+ ip.charAt(0);
        String op2 = op+ String.valueOf(ip.charAt(0)).toUpperCase();
        ip = ip.substring(1);
        solve(ip, op1, res);
        solve(ip, op2,res);
    }
    public static void main(String[] args) {
        UpperLow object = new UpperLow();
        System.out.print("\n[");
        for ( String i : object.upperLower("abc")){
            System.out.print("\""+i+"\", ");
        }
        System.out.print("]\n");
    }
}
